package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P010_11003_최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		///////////// solve 못했습니다 /////////////

		long[] answer = new long[N];
		long min = 1000000000;
		long secondMin = 1000000000;
		long thirdMin = 1000000000;

		// [i - L] index가 음수 ~ 0일 때까지는 0~i까지의 최솟값 구하기
		for (int i = 0; i <= (L - 1); i++) {
			if (arr[i] < min) {
				thirdMin = secondMin;
				secondMin = min;
				min = arr[i];
			}else if(arr[i] < secondMin){
				thirdMin = secondMin;
				secondMin = arr[i];
			}
			answer[i] = min;
		}

		for (int i = L; i <= N - (L - 1); i++) {
			if (arr[i - L] == min) {
				if (arr[i] < secondMin) {
					min = arr[i];
				} else {
					min = secondMin;
					secondMin = thirdMin;
				}
			}else {
				if (arr[i] < min) {
					thirdMin = secondMin;
					secondMin = min;
					min = arr[i]; 
				}
			}
			answer[i] = min;
		}
		
		// 마지막 L개의 index 최솟값 구하기
		
		

		for (long l : answer) {
			System.out.print(l + " ");
		}
	}
}
