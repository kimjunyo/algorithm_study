package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주차시스템 {
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken()); // 주차장 행의 수
		col = Integer.parseInt(st.nextToken()); // 주차장 열의 수
		arr = new int[row][col];
		visit = new boolean[row][col];
		int max = 0;

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 주어진 배열 완성

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] != 1 && !visit[i][j]) {
					int count = bfs(i, j); // 주차 점수 반환.
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(max);

	}// main

	static int bfs(int i, int j) {
		Queue<int[]> needtovisit = new ArrayDeque<>();
		needtovisit.add(new int[] { i, j });
		int count = 0;
		if (arr[i][j] == 0)
			count++;
		else
			count -= 2;
		visit[i][j] = true;

		while (!needtovisit.isEmpty()) {
			int[] deque = needtovisit.poll();
			int x = deque[0];
			int y = deque[1];
			for (int d = 0; d < 4; d++) {
				int adjx = x + dx[d];
				int adjy = y + dy[d];
				if (adjx >= 0 && adjy >= 0 && adjx < row && adjy < col && arr[adjx][adjy] != 1 && !visit[adjx][adjy]) {
					if (arr[adjx][adjy] == 0)
						count++;
					else
						count -= 2;
					visit[adjx][adjy] = true;
					needtovisit.add(new int[] { adjx, adjy });
				}
			}
		}
		return count;
	}// bfs
}
