package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 스도쿠 {
	static int[][] arr;
	static Set<Integer>[] row, col, box;
	/*
	 * box 번호.3x3으로 할때 해당 박스내에 가지고 있는 숫자. 0,3,6 1,4,7 2,5,8
	 */

	static boolean isFind;
	static ArrayList<int[]> list;
	static StringBuilder result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		result = new StringBuilder();

		arr = new int[9][9];
		row = new HashSet[9]; // 각 행마다 가지고 있는 숫자.
		col = new HashSet[9]; // 각 열마다 가지고 있는 숫자.
		box = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			row[i] = new HashSet<Integer>();
			col[i] = new HashSet<Integer>();
			box[i] = new HashSet<Integer>();
		}
		list = new ArrayList<>(); // 숫자를 넣어야할 좌표.
		for (int i = 0; i < 9; i++) {
			StringBuilder str = new StringBuilder(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if (arr[i][j] != 0) {
					row[i].add(arr[i][j]);
					col[j].add(arr[i][j]);
					input(i, j, arr[i][j]);
				} else {
					list.add(new int[] { i, j });
				}

			}
		} // 주어진 스도쿠 완성
		list.add(new int[] { 9, 9 });
		isFind = false;
		int[] start = list.get(0);
		recur(start[0], start[1], 0);
		bw.write(result.toString().trim());
		bw.flush();

	}// main

	static void input(int x, int y, int num) {
		if (x < 3) {
			if (y < 3) {
				box[0].add(num);
			} else if (y >= 3 && y < 6) {
				box[1].add(num);
			} else {
				box[2].add(num);
			}
		} else if (x >= 3 && x < 6) {
			if (y < 3) {
				box[3].add(num);
			} else if (y >= 3 && y < 6) {
				box[4].add(num);
			} else {
				box[5].add(num);
			}
		} else {
			if (y < 3) {
				box[6].add(num);
			} else if (y >= 3 && y < 6) {
				box[7].add(num);
			} else {
				box[8].add(num);
			}
		}
	}

	static void remove(int x, int y, int num) {
		if (x < 3) {
			if (y < 3) {
				box[0].remove(num);
			} else if (y >= 3 && y < 6) {
				box[1].remove(num);
			} else {
				box[2].remove(num);
			}
		} else if (x >= 3 && x < 6) {
			if (y < 3) {
				box[3].remove(num);
			} else if (y >= 3 && y < 6) {
				box[4].remove(num);
			} else {
				box[5].remove(num);
			}
		} else {
			if (y < 3) {
				box[6].remove(num);
			} else if (y >= 3 && y < 6) {
				box[7].remove(num);
			} else {
				box[8].remove(num);
			}
		}
	}

	static boolean isContain(int x, int y, int num) {
		if (x < 3) {
			if (y < 3) {
				return box[0].contains(num);
			} else if (y >= 3 && y < 6) {
				return box[1].contains(num);
			} else {
				return box[2].contains(num);
			}
		} else if (x >= 3 && x < 6) {
			if (y < 3) {
				return box[3].contains(num);
			} else if (y >= 3 && y < 6) {
				return box[4].contains(num);
			} else {
				return box[5].contains(num);
			}
		} else {
			if (y < 3) {
				return box[6].contains(num);
			} else if (y >= 3 && y < 6) {
				return box[7].contains(num);
			} else {
				return box[8].contains(num);
			}
		}
	}

	static void recur(int x, int y, int order) {
		if (x == 9 && y == 9) {
			for (int i = 0; i < 9; i++) {

				for (int j = 0; j < 9; j++) {
					result.append(arr[i][j]);
				}
				result.append("\n");
			}
			// 출력

			isFind = true;
			return;
		}

		for (int num = 1; num <= 9; num++) {
			if (isFind)
				return;
			if (!row[x].contains(num) && !col[y].contains(num) && !isContain(x, y, num)) {
				arr[x][y] = num;
				row[x].add(num);
				col[y].add(num);
				input(x, y, num);
				int[] next = list.get(order + 1);
				recur(next[0], next[1], order + 1);
				arr[x][y] = 0;
				row[x].remove(num);
				col[y].remove(num);
				remove(x, y, num);

			}
		}
	}
}
