package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][3];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][2];
		int idx = 0;

		if (arr[idx][0] <= arr[idx][1] && arr[idx][0] <= arr[idx][2]) {
			idx = 0;
		} else if (arr[idx][1] <= arr[idx][0] && arr[idx][1] <= arr[idx][2]) {
			idx = 1;
		} else {
			idx = 2;
		}
		dp[0][0] = idx;
		dp[0][1] = arr[0][idx];

		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < 3; i++) {
			if (i == dp[0][0]) {
				continue;
			}
			if (arr[1][i] < min) {
				min = arr[1][i];
				minIdx = i;
			}
		}
		dp[1][0] = minIdx;
		dp[1][1] = dp[0][1] + min;

		for (int i = 2; i < N; i++) {
			getMinIdx(i);
		}
//		for (int[] temp : dp) {
//			System.out.println(Arrays.toString(temp));
//		}
		System.out.println(dp[N - 1][1]);
	}

	static void getMinIdx(int idx) {
//		for (int[] temp : dp) {
//			System.out.println(Arrays.toString(temp));
//		}
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < 3; i++) {
			if (i == dp[idx - 1][0]) {
				continue;
			}
			if (arr[idx][i] < min) {
				min = arr[idx][i];
				minIdx = i;
			}
		}

		int[] case1 = new int[] { minIdx, dp[idx - 1][1] + min };
		int[] case2 = new int[2];

		for (int i = 0; i < 3; i++) {
			if (i == dp[idx - 2][0] || i == dp[idx - 1][0]) {
				continue;
			}
			case2[0] = dp[idx - 1][0];
			case2[1] = dp[idx - 2][1] + arr[idx - 1][i] + arr[idx][dp[idx - 1][0]];
		}

		if (case1[1] < case2[1]) {
			dp[idx] = case1;
		} else {
			dp[idx] = case2;
		}
	}
}
