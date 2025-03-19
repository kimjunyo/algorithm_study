package com.ssafy.siyeong;

import java.util.Scanner;

public class a123더하기_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		for (int i = 0; i < N; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
