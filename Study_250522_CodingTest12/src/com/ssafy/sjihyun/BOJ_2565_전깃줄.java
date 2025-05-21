package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_2565_전깃줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] wires = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wires[i][0] = Integer.parseInt(st.nextToken()); // A
			wires[i][1] = Integer.parseInt(st.nextToken()); // B
		}
		Arrays.sort(wires, (e1, e2) -> Integer.compare(e1[0], e2[0]));

		int[] dp = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (wires[i][1] > wires[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(N - result);
	}
}
