package com.ssafy.siyeong;

import java.util.Scanner;

public class ABCDE_13023 {
	static int N;
	static int M;
	static boolean result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		result = false;
		for (int i = 0; i < N; i++) {
			if (result)
				break;
			dfs(i, 0, map, visited);
		}
		System.out.println(result ? 1 : 0);
	}

	private static void dfs(int x, int depth, int[][] map, boolean[] visited) {
		if (depth == 4) {
			result = true;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (map[x][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1, map, visited);
				visited[i] = false;
			}
		}
		
	}
}
