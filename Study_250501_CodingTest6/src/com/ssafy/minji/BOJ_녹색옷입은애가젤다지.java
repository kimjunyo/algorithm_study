package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_녹색옷입은애가젤다지 {
	public static void main(String[] args) throws IOException {
		final int MAXVAL = 125 * 125 * 9;
		int tc = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		while (N != 0) {
			StringTokenizer st = null;
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] { 0, 0 });
			dp[0][0] = map[0][0];

			int[] dr = { -1, 0, 0, 1 };
			int[] dc = { 0, -1, 1, 0 };
			int[] temp;
			int r, c, newR, newC;
			int ans = -1;
			while (!que.isEmpty()) {
				temp = que.poll();
				r = temp[0];
				c = temp[1];
				if (r == N - 1 && c == N - 1) {
					ans = dp[r][c];
				}

				for (int d = 0; d < 4; d++) {
					newR = r + dr[d];
					newC = c + dc[d];
					if (newR >= 0 && newR < N && newC >= 0 && newC < N && dp[r][c] + map[newR][newC] < dp[newR][newC]) {
						que.add(new int[] { newR, newC });
						dp[newR][newC] = dp[r][c] + map[newR][newC];
					}
				}
			}
			System.out.println("Problem " + tc++ + ": " + ans);

			N = Integer.parseInt(br.readLine().trim());
		}
	}
}
