package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P027_2178_미로탐색 {
	static int[][] maze;
	static boolean[][] visited;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				maze[i][j] = (int)(input.charAt(j) - '0');
			}
		}

		BFS(0, 0);
		System.out.println(maze[N - 1][M - 1]);
	}

	static void BFS(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });
		visited[0][0] = true;
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		int[] idx = new int[2];
		int newI = 0;
		int newJ = 0;
		while (!que.isEmpty()) {
			idx = que.poll();
			for (int d = 0; d < 4; d++) {
				newI = idx[0] + dr[d];
				newJ = idx[1] + dc[d];
				if (newI >= 0 && newI < N && newJ >= 0 && newJ < M && visited[newI][newJ] == false
						&& maze[newI][newJ] == 1) {
					que.add(new int[] { newI, newJ });
					visited[newI][newJ] = true;
					maze[newI][newJ] = maze[idx[0]][idx[1]] + 1;
				}
			}

		}
	}
}
