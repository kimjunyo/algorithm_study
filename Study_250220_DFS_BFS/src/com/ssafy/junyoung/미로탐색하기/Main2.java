package com.ssafy.junyoung.미로탐색하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;

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

		visited[0][0] = true;

		System.out.println(bfs(new Node(0, 0, 1)));
	}

	private static int bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (true) {
			Node n = q.poll();

			if(n.col == N-1 && n.row == M-1) {
				return n.distance;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = n.col + dr[i];
				int nc = n.row + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, n.distance + 1));
				}
			}
		}
	}

	static class Node {
		int col;
		int row;
		int distance;

		public Node(int col, int row, int distance) {
			this.col = col;
			this.row = row;
			this.distance = distance;
		}

	}
}
