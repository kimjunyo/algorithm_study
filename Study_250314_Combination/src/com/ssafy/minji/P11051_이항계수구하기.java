package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051_이항계수구하기 {
	static int N;
	static int K;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K || K == 0) {
			System.out.println(1);
			return;
		}

		dp = new long[N + 1];
		dp[1] = 1;
		calc(2);

		System.out.println((dp[N] / (dp[K] * dp[N - K])) % 10007);

	}

	static void calc(int idx) {
		if(idx > N) {
			return;
		}
		dp[idx] = (((idx - 1) % 10007) * (idx % 10007)) % 10007;
		System.out.println(idx + " , " + dp[idx]);
		calc(idx + 1);
	}
}
