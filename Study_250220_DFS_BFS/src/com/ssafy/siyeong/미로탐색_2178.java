package com.ssafy.siyeong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {

	static int N;
	static int M;
//	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][M];
		visited = new boolean[N][M];
		min = Integer.MAX_VALUE; 

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
//		시간초과
//		dfs(0, 0, 1);
		bfs(0, 0, map);
		
		System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs(int r, int c, int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int a = q.peek()[0];
			int b = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int newR = a + dr[i];
				int newC = b + dc[i];
				if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
					if (map[newR][newC] == 1 && !visited[newR][newC]) {
						q.add(new int[] {newR, newC});
						visited[newR][newC] = true;
						map[newR][newC] = map[a][b] + 1;
					}
				}
			}
		}
	}

	private static void dfs(int r, int c, int depth, int[][] map) {
		if (r == N -1 && c == M - 1) {
			if (depth < min)
				min = depth;
			return;
		}		

		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
				if (map[newR][newC] == 1 && !visited[newR][newC]) {
					visited[newR][newC] = true;
					dfs(newR, newC, depth + 1, map);
					visited[newR][newC] = false;
				}
			}
		}

	}
}
