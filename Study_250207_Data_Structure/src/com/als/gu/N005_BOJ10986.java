package com.als.gu;

import java.util.Scanner;

public class N005_BOJ10986 {
	public static void main(String[] args) {
		
		// 입력값으로 변수 초기화
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];		// 입력값 받을 배열 생성
		long[] arrSum = new long[N];	// 구간합 저장할 배열 생성
		
		// 0번 인덱스 값 세팅
		arr[0] = sc.nextInt();
		arrSum[0] = arr[0];
		
		
		for (int i = 1; i < N; i++) {
			arr[i] = sc.nextInt();
			arrSum[i] = arrSum[i-1] + arr[i];
		}
		
		
		/*
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arrSum[i] % M == 0) cnt++;							// 처음부터 i까지의 구간합이 조건에 만족하는 케이스
			
			for (int j = 0; j < i; j++) {							// j부터 i까지의 구간합이 조건에 만족하는 케이스
				if (((arrSum[i] - arrSum[j]) % M) != 0) continue;
				cnt++;
			}
		}
		*/
		
		// 핵심 아이디어 : 두 수의 차가 M으로 나눠떨어지면 두 수의 나머지는 서로 같다
		
		int[] remainCnt = new int[M];			// 구간합의 나머지에 해당하는 값이 몇 개인지 기록하는 배열
		
		for (long prefixSum : arrSum) {
			remainCnt[(int)(prefixSum % M)]++;			// 나머지와 일치하는 인덱스에 해당하는 값++
		}
		
		long cnt = remainCnt[0];					// 나머지가 0인 구간합 개수부터 시작
		for (int remain : remainCnt) {
			cnt += (long)remain*(remain - 1) / 2;		// 동일한 나머지를 가진 구간합들끼리의 순서쌍을 찾기 위해 Combination 사용
		}
		
		System.out.println(cnt);
		
	}
}
