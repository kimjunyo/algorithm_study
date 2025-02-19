package com.ssafy.junyoung.미로탐색하기;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, distance, min;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String input = scan.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		min = Integer.MAX_VALUE;
		distance = 1;
		visited[0][0] = true;
		dfs(0, 0);
		
		System.out.println(min);
	}

	private static void dfs(int i, int j) {
		if (i == N - 1 && j == M - 1) {
			min = Math.min(min, distance);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if(nr >= 0 && nr < N && nc >=0 && nc<M && arr[nr][nc] == 1 && !visited[nr][nc]) {
				distance++;
				visited[nr][nc] = true;
				dfs(nr, nc);
				distance--;
				visited[nr][nc] = false;
			}
		}
	}
}
