package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	static int[] dx = { -1, 1, 0, 0, 0, 0 }; // 상하좌우, z상,z하
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());// 열
		int N = Integer.parseInt(st.nextToken());// 행
		int H = Integer.parseInt(st.nextToken());// 높이
		int[][][] arr = new int[H][N][M];
		Queue<Node> needtovisit = new ArrayDeque<>();
		boolean[][][] visit = new boolean[H][N][M];

		int totalZero = 0;

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					arr[h][n][m] = Integer.parseInt(st.nextToken());
					if (arr[h][n][m] == 1) {
						needtovisit.add(new Node(n, m, h));
						visit[h][n][m] = true;
					} else if (arr[h][n][m] == 0) {
						totalZero++;
					} else {
						visit[h][n][m] = true;
					}
				}
			}
		} // 주어진 배열 저장

		if (totalZero == 0) {
			System.out.println(0);
			return;
		}
		int count = -1;

		while (!needtovisit.isEmpty()) {
			int length = needtovisit.size();
			for (int i = 0; i < length; i++) {
				Node node = needtovisit.poll();
				int x = node.x;
				int y = node.y;
				int z = node.z;
				for (int d = 0; d < 6; d++) {
					int adjx = x + dx[d];
					int adjy = y + dy[d];
					int adjz = z + dz[d];
					if (adjx < 0 || adjy < 0 || adjz < 0 || adjx >= N || adjy >= M || adjz >= H
							|| visit[adjz][adjx][adjy] || arr[adjz][adjx][adjy] == -1)
						continue;
					visit[adjz][adjx][adjy] = true;
					needtovisit.add(new Node(adjx, adjy, adjz));
					totalZero--;

				}
			}
			count++;
		}
		if (totalZero > 0)
			System.out.println(-1);
		else
			System.out.println(count);

	}// main

	static class Node {
		int x, y, z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
