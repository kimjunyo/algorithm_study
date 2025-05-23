package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약 {
	static char[][] arr, arr2;// 정상 RGB , 적록색약 RB
	static boolean[][] visit, visit2;
	static int n;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new char[n][n];
		arr2 = new char[n][n];
		visit = new boolean[n][n];
		visit2 = new boolean[n][n];
		String str = null;
		for (int i = 0; i < n; i++) {
			str = br.readLine().trim();
			for (int j = 0; j < n; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;

				if (c == 'G')
					arr2[i][j] = 'R';
				else
					arr2[i][j] = c;
			}
		} // 주어진 배열 .
		int count = 0;
		int count2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					bfs(arr, visit, i, j);
					count++;
				}
				if (!visit2[i][j]) {
					bfs(arr2, visit2, i, j);
					count2++;
				}

			}
		}

		System.out.println(count + " " + count2);

	}// main

	static void bfs(char[][] arr, boolean[][] visit, int i, int j) {
		Queue<int[]> needtovisit = new ArrayDeque<>();
		visit[i][j] = true;
		needtovisit.add(new int[] { i, j });
		char c = arr[i][j];
		while (!needtovisit.isEmpty()) {
			int[] xy = needtovisit.poll();
			int x = xy[0];
			int y = xy[1];
			for (int d = 0; d < 4; d++) {
				int adjx = x + dx[d];
				int adjy = y + dy[d];
				if (adjx < 0 || adjy < 0 || adjx >= n || adjy >= n || visit[adjx][adjy] || arr[adjx][adjy] != c)
					continue;
				needtovisit.add(new int[] { adjx, adjy });
				visit[adjx][adjy] = true;

			}
		}
	}// bfs

}
