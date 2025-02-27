package com.ssafy.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343_2 {
	static int N;
	static int M;
	static int[] lectures;
	static int discSize = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-M; i++) {
			int gijun = 0;
			int maxSum = 0;
			for (int j = 0; j <= i; j++) {
				gijun += lectures[j];
			}
			
			int sum = 0;
			int idx = i;
			int m = 1;
			while (m < M) {
				for (int j = idx+1; j < N; j++) {
					sum += lectures[j];
					if (m < M-1) {
						if (sum == gijun) {
							idx = j;
							maxSum = Math.max(maxSum, sum);
							sum = 0;
							break;
						}
						if (sum > gijun) {
							if (sum - gijun > gijun - (sum-lectures[j])) {
								idx = j-1;
								maxSum = Math.max(maxSum, sum-lectures[j]);
								sum = 0;
								break;
							} else {
								idx = j;
								maxSum = Math.max(maxSum, sum);
								sum = 0;
								break;
							}
						}
					} else if (j == N-1) {
						maxSum = Math.max(maxSum, sum);
					}
				}
				m++;
			}
			discSize = Math.min(discSize, maxSum);
		}
		

		
		System.out.println(discSize);
	}

}
