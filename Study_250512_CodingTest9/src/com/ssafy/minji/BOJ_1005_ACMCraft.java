package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {

	static int W;
	static int wDepth;
	static List<Integer>[] rules;
	static int[] time;
	static int[] depth;
	static int[] maxPerDepth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];
			rules = new List[N + 1];
			for (int i = 0; i < N + 1; i++) {
				rules[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			int x, y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				rules[y].add(x);
			}

			W = Integer.parseInt(br.readLine().trim());
			depth = new int[N + 1];
			maxPerDepth = new int[N + 1];
			depth[0] = -1;

			wDepth = DFS(W);

			long ans = 0;
			for (int i = 1; i <= wDepth; i++) {
//				System.out.println(i + ", " + maxPerDepth[i]);
				ans += maxPerDepth[i];
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int DFS(int n) {
		if (depth[n] != 0) {
			return depth[n];
		}

		if (rules[n].isEmpty()) {
			depth[n] = 1;
		} else {
			int maxDepth = 0;
			for (int m : rules[n]) {
				maxDepth = Math.max(maxDepth, DFS(m));
			}

			depth[n] = maxDepth + 1;

		}

		if (maxPerDepth[depth[n]] < time[n]) {
			maxPerDepth[depth[n]] = time[n];
		}
//		System.out.println(n + " depth : " + depth[n]);
		return depth[n];
	}
}
