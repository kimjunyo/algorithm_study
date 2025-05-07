package com.ssafy.minji;

import java.io.*;
import java.util.*;

public class BOJ_2239_스도쿠 {

	static int[][] board = new int[9][9];
	static List<int[]> blanks = new ArrayList<>();
	static List<Integer>[][] ableList = new ArrayList[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		for (int i = 0; i < 9; i++) {
			str = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				ableList[i][j] = new ArrayList<>();
				if (board[i][j] == 0) {
					blanks.add(new int[]{i, j});
					for (int k = 1; k <= 9; k++) {
						if (isValid(i, j, k)) {
							ableList[i][j].add(k);
						}
					}
					Collections.sort(ableList[i][j]);
				}
			}
		}
		dfs(0);
	}

	static void dfs(int depth) {
		if (depth == blanks.size()) {
			printBoard();
			System.exit(0);
		}

		int[] pos = blanks.get(depth);
		int r = pos[0];
		int c = pos[1];

		for (int num : ableList[r][c]) {
			if (isValid(r, c, num)) {
				board[r][c] = num;
				dfs(depth + 1);
				board[r][c] = 0;
			}
		}
	}

	static boolean isValid(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == num || board[i][c] == num) return false;
		}

		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (board[i][j] == num) return false;
			}
		}

		return true;
	}

	static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for (int[] row : board) {
			for (int num : row) {
				sb.append(num);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
