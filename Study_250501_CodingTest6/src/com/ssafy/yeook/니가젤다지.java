package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 니가젤다지 {
	public static int[] dx = { -1, 1, 0, 0 };// 상,하,좌,우
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;

		int t = 1; // 문제번호
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 행열의 갯수.
			if (n == 0)
				break; // 끝남.
			int[][] arr = new int[n][n]; // 기존 배열
			int[][] shortestpath = new int[n][n]; // 최단거리 저장 배열
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					shortestpath[i][j] = Integer.MAX_VALUE; // 전부 최대 거리로 저장
				}
			} // 배열 채우기.

			boolean[][] visit = new boolean[n][n];
			PriorityQueue<Node> needtovisit = new PriorityQueue<>();

			needtovisit.add(new Node(0, 0, 0));// x,y,최단거리값.
			while (!needtovisit.isEmpty()) {
				Node deque = needtovisit.poll();
				int x = deque.x;
				int y = deque.y;
				int cost = deque.cost;
				if (visit[x][y]) {
					continue;
				}
				visit[x][y] = true;

				for (int d = 0; d < 4; d++) {
					int adjx = x + dx[d];
					int adjy = y + dy[d];
					if (adjx < 0 || adjy < 0 || adjx >= n || adjy >= n) {
						continue;
					}
					if (!visit[adjx][adjy] && (shortestpath[adjx][adjy] > cost + arr[adjx][adjy])) {
						shortestpath[adjx][adjy] = cost + arr[adjx][adjy];
						needtovisit.add(new Node(adjx, adjy, shortestpath[adjx][adjy]));
					}
				}
			} // while
			result.append(String.format("Problem %d: %d%n", t, shortestpath[n - 1][n - 1] + arr[0][0]));
			t++;
		} // 0나올때까지 while
		bw.write(result.toString().trim());
		bw.flush();

	}// main

	static class Node implements Comparable<Node> {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}