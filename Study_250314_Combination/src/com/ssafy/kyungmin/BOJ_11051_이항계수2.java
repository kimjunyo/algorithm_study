package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2 {
	static int[][] memo;
	static int MOD = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1~1000
		int N = Integer.parseInt(st.nextToken());
		// 0~N
		int K = Integer.parseInt(st.nextToken());

		memo = new int[N + 1][K + 1];

		int res = binomialCoefficient(N, K);
		System.out.println(res);
	}

	private static int binomialCoefficient(int n, int k) {
//		for (int i = 0; i < memo.length; i++) {
//			System.out.println(Arrays.toString(memo[i]));
//		}
//		System.out.println();

		if (k == 0 || k == n)
			return 1;

		if (memo[n][k] > 0)
			return memo[n][k];

		return memo[n][k] = (binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k)) % MOD;
	}
}