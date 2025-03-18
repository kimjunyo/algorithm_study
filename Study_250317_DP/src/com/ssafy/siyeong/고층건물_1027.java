package com.ssafy.siyeong;

import java.util.Scanner;

public class 고층건물_1027 {
	static int[] dp;
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
		}
		for (int i = N - 1; i >= 0; i--) {
			if (i + arr[i][0] > N) {
				dp[i] = dp[i + 1];
			}
			else {
				dp[i] = Math.max(dp[i + 1], arr[i][1] + dp[i + arr[i][0]]);
			}
		}
		System.out.println(dp[0]);
		
	}
}
