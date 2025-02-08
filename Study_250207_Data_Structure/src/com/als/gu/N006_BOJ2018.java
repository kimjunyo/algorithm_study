package com.als.gu;

import java.util.Scanner;

public class N006_BOJ2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] preSum = new int[N+1];
		
		preSum[0] = 0;
		for (int i = 1; i <= N; i++) {
			preSum[i] = preSum[i-1] + i;
		}
		
		int cnt = 1;
		int s = 0;
		int e = 1;
		
		while (e <= N) {
			int diff = preSum[e] - preSum[s];
			if (e - s == 1) {
				e++;
			} else if (diff == N) {
				cnt++;
				e++;
			} else if (diff < N) {
				e++;
			} else {
				s++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
