package com.ssafy.siyeong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS_1260 {
	private static void dfs(int x, int N, int[][] arr, int[] visited) {
		System.out.print(x + " ");
		visited[x] = 1;

		for (int i = 1; i <= N; i++) {
			if (arr[x][i] == 1 && visited[i] == 0)
				dfs(i, N, arr, visited);
		}
	}

	private static void bfs(int x, int N, int[][] arr, int[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[x] = 1;
		q.add(x);
		while(!q.isEmpty()) {
			int nowX = q.poll();
			System.out.print(nowX + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[nowX][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		int[][] arr = new int[N + 1][N + 1];
		int[] visited = new int[N + 1];
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}

		dfs(V, N, arr, visited);
		System.out.println();
		visited = new int[N + 1];
		bfs(V, N, arr, visited);
		System.out.println();
	}


}
