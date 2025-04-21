package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중첩점 {
	static int n, m;
	static Node[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new Node[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);

			write(x, y, direction);
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] != null) {
					sum += (arr[i][j].row * arr[i][j].col);
				}
			}
		}
		System.out.println(sum);

	}// main

	static void write(int x, int y, char direction) {
		int d = 0;
		if (direction == 'D')
			d = 1;
		if (direction == 'L')
			d = 2;
		if (direction == 'R')
			d = 3;

		if (d == 0 || d == 1) {
			for (int k = 0; k <= n; k++) {
				int adjx = x + dx[d] * k;
				int adjy = y + dy[d] * k;
				if (adjx > 0 && adjy > 0 && adjx <= n && adjy <= n) {
					if (arr[adjx][adjy] == null)
						arr[adjx][adjy] = new Node(0, 1);
					else
						arr[adjx][adjy].col++;
				} else
					break;
			}
		} else {
			for (int k = 0; k <= n; k++) {
				int adjx = x + dx[d] * k;
				int adjy = y + dy[d] * k;
				if (adjx > 0 && adjy > 0 && adjx <= n && adjy <= n) {
					if (arr[adjx][adjy] == null)
						arr[adjx][adjy] = new Node(1, 0);
					else
						arr[adjx][adjy].row++;
				} else
					break;
			}
		}
	}// write

	static class Node {
		int row, col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}