package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {
	public static int MOD = 10007;
	public static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];

		// 2*1을 넣을때 c는 무조건 1개, 1 증가
		// 1*2을 넣을때 c는 무조건 2개, 2 증가
		int res = pb(N);

		System.out.println(res);
	}

	/**
	 * 
	 * @param n
	 */
	public static int pb(int n) {
		if (n == 1) {
			return memo[1] = 1;
		}
		if (n == 2) {
			return memo[2] = 2;
		}
		// 불러오지 않으면 memo를 안쓰는 꼴
		if (memo[n] > 0) {
			return memo[n];
		}
		return memo[n] = (pb(n - 1) % MOD + pb(n - 2) % MOD) % MOD;
	}
}
