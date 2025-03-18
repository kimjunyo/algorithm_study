package com.ssafy.yeook;

import java.util.Scanner;

public class 타일링2n_11726 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();

		int[] dp = new int[n + 1];
		if (n >= 1) {
			dp[1] = 1;
		}
		if (n >= 2) {
			dp[2] = 2;
		}
		if (n >= 3) {
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
		}

		System.out.println(dp[n]);
	}

}
