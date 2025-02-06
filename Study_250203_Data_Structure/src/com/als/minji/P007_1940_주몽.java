package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P007_1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int n1 = 0;
		int n2 = 1;
		int sum = 0;
		int cnt = 0;
		
		// 연산 14번 수행
		recnt:
		while(n2 < N) {
			sum = nums[n1] + nums[n2];
			if(sum < M && n2 != N-1) {
				n2++;
				continue recnt;
			}
			
			if(sum == M) cnt++;
			n1++;
			n2 = n1 + 1;
		}
		
			// 아래 코드에서 반복되는 부분 정리한 게 위 코드
//		while(n2 < N) {
//			sum = nums[n1] + nums[n2];
//			if(sum == M) {
//				cnt++;
//				n1++;
//				n2 = n1 + 1;
//			}else if(sum < M) {
//				if(n2 == N-1) {
//					n1++;
//					n2 = n1 + 1;
//				}
//				n2++;
//			}else {
//				n1++;
//				n2 = n1 + 1;
//			}
//		}
		
		
		// 교재 모범답안 : 연산 4번 수행
//		int i = 0;
//		int j = N-1;
//		while(i< j) {
//			tryNum++;
//			if(nums[i] + nums[j] < M) {
//				i++;
//			}else if(nums[i] + nums[j] > M) {
//				j--;
//			}else {
//				cnt++;
//				i++;
//				j--;
//			}
//		}
		
		System.out.println(cnt);
	}
}
