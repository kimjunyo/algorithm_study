package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class 불이야 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		StringBuilder str;
		char[][] arr = new char[R][C];
		Queue<int[]> needtovisit = new ArrayDeque<>();
		boolean[][] visit = new boolean[R][C];
		boolean isFind = false; // 구름이 자리로 번질수 있는지
		for (int i = 0; i < R; i++) {
			str = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '@') {
					needtovisit.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		} // 연구실저장.

		int count = 0; // 몇초 걸리는지
		// bfs
		outer: while (!needtovisit.isEmpty()) {
			int length = needtovisit.size();
			for (int i = 0; i < length; i++) {
				int[] deque = needtovisit.poll();
				int x = deque[0];
				int y = deque[1];
				for (int d = 0; d < 4; d++) {
					int adjx = x + dx[d];
					int adjy = y + dy[d];
					if (adjx >= 0 && adjy >= 0 && adjx < R && adjy < C && !visit[adjx][adjy]
							&& arr[adjx][adjy] != '#') {
						if (arr[adjx][adjy] == '&') {
							isFind = true;
							break outer; // 구름이와 인접하면 반복문 탈출.
						}
						visit[adjx][adjy] = true;
						needtovisit.add(new int[] { adjx, adjy });
					}
				} // 사방탐색
			} // 같은 시간내
			count++;

		} // bfs

		if (isFind)
			System.out.println(count);
		else
			System.out.println(-1);

	}
}
