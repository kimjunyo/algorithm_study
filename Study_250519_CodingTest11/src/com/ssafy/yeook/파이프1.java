package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프1 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		State[][] state = new State[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				state[i][j] = new State(0, 0, 0);
			}
		} // 주어진 배열 저장.
		state[0][1].row = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				if (arr[i][j] == 0) {
					if (isOk(i, j, 1)) {
						state[i][j + 1].row += state[i][j].row + state[i][j].dia;
					}
					if (isOk(i, j, 2)) {
						state[i + 1][j].col += state[i][j].col + state[i][j].dia;
					}
					if (isOk(i, j, 3)) {
						state[i + 1][j + 1].dia += state[i][j].row + state[i][j].col + state[i][j].dia;
					}

				}
			}
		} // for

		n--;
		System.out.println(state[n][n].row + state[n][n].col + state[n][n].dia);

	}// main

	static boolean isOk(int x, int y, int d) {
		int nx = x + 1;
		int ny = y + 1;

		if (d == 1 && ny < n && arr[x][ny] == 0)
			return true;

		if (d == 2 && nx < n && arr[nx][y] == 0)
			return true;

		if (d == 3 && nx < n && ny < n && arr[x][ny] == 0 && arr[nx][y] == 0 && arr[nx][ny] == 0)
			return true;

		return false;
	}

	static class Node implements Comparable<Node> {
		int x, y;// 행,열
		int direction;// 파이프 방향(가로=1,세로=2,대각선=3)

		public Node(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public int compareTo(Node o) {
			if (o.x == this.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	static class State {
		int row, col, dia;// 가로,세로,대각선 경우의 수 저장.

		public State(int row, int col, int dia) {
			this.row = row;
			this.col = col;
			this.dia = dia;
		}
	}
}
