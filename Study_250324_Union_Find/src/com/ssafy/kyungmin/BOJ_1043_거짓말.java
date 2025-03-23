package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 사람 수
		int N = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		// 파티 수
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 진실을 아는 사람수
		int knowTruth = Integer.parseInt(st.nextToken());
		for (int i = 0; i < knowTruth; i++) {
			parent[Integer.parseInt(st.nextToken())] = -1;
		}

		int[][] parties = new int[M][];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int participants = Integer.parseInt(st.nextToken());
			parties[i] = new int[participants];
			for (int j = 0; j < participants; j++) {
				parties[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < participants - 1; j++) {
				union(parties[i][j], parties[i][j + 1]);
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			boolean canLie = true;
			for (int j = 0; j < parties[i].length; j++) {
				if (parties[i][j] == 0) {
					break;
				} else if (find(parties[i][j]) == -1) {
					canLie = false;
					break;
				}
			}
			if (canLie) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == -1 && rootY > -1) {
			parent[rootY] = rootX;
			return;
		} else if (rootY == -1 && rootX > -1) {
			parent[rootX] = rootY;
			return;
		}

		if (rootX == rootY)
			return;

		parent[rootX] = rootY;
	}

	private static int find(int x) {
		if (parent[x] != x) {
			if (parent[x] == -1)
				return -1;
			return parent[x] = find(parent[x]);
		}
		return x;
	}
}
