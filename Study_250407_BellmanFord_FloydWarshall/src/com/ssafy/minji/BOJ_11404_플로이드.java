package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());

		final int INF = 1000_000_000;
		long[][] dist = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		int from;
		int to;
		int cost;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			if (dist[from][to] > cost) {
				dist[from][to] = cost;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == INF) {
					sb.append(0);
				} else {
					sb.append(dist[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
