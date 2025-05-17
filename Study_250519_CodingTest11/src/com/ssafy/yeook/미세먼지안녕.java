package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static int R, C, T; // 행, 열, 초
	static int[][] arr;
	static int[] up, down;
	static int[] upDir = { 0, 3, 1, 2 }; // 상,우, 하,좌
	static int[] downDir = { 1, 3, 0, 2 }; // 하, 우, 상, 좌
	static Set<Integer> dust;

	static int[] dx = { -1, 1, 0, 0 };// 상하좌우.
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C]; // 미세먼지 저장.
		up = new int[2];
		down = new int[2];
		dust = new HashSet<Integer>();
		Arrays.fill(up, -1);
		Arrays.fill(down, -1);

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					if (up[0] == -1) {
						up[0] = i;
						up[1] = j;
					} else {
						down[0] = i;
						down[1] = j;
					}
				} else if (arr[i][j] > 0) {
					dust.add(i * C + j);
				}
			}
		} // 미세먼지 저장.

		while (T > 0 && dust.size() > 0) {
			spread();
			circulation();
			dustUpdate();

			T--;
		} // T
		int result = 0;
		if (dust.size() > 0) {
			for (Integer xy : dust) {
				result += arr[xy / C][xy % C];
			}
		} else {
			System.out.println(0);
			return;
		}
		System.out.println(result);

	}// main

	static void spread() {
		int[][] nextArr = new int[R][C];
		for (Integer xy : dust) {
			int x = xy / C;
			int y = xy % C;
			int value = arr[x][y] / 5;
			if (value > 0) {
				for (int d = 0; d < 4; d++) {
					int adjx = x + dx[d];
					int adjy = y + dy[d];
					if (adjx >= 0 && adjy >= 0 && adjx < R && adjy < C && arr[adjx][adjy] != -1) {
						arr[x][y] -= value;
						nextArr[adjx][adjy] += value;
					}
				}

			}
			nextArr[x][y] += arr[x][y];
		}
		arr = nextArr;
		arr[up[0]][up[1]] = -1;
		arr[down[0]][down[1]] = -1;
	}

	static void circulation() {
		int curx = up[0];
		int cury = up[1];
		int nx = -1;
		int ny = -1;
		int d = 0;
		while (true) {
			nx = curx + dx[upDir[d]];
			ny = cury + dy[upDir[d]];
			if (nx < 0 || ny < 0 || nx > up[0] || ny >= C) {
				d++;
				if (d == 4)
					d = 0;
				nx = curx + dx[upDir[d]];
				ny = cury + dy[upDir[d]];

			}

			if (nx != up[0] || ny != up[1]) {
				arr[curx][cury] = arr[nx][ny];
				curx = nx;
				cury = ny;
			} else {
				arr[curx][cury] = 0;
				break;
			}

		}

		curx = down[0];
		cury = down[1];
		nx = -1;
		ny = -1;
		d = 0;
		while (true) {
			nx = curx + dx[downDir[d]];
			ny = cury + dy[downDir[d]];
			if (nx < down[0] || ny < 0 || nx >= R || ny >= C) {
				d++;
				if (d == 4)
					d = 0;
				nx = curx + dx[downDir[d]];
				ny = cury + dy[downDir[d]];

			}

			if (nx != down[0] || ny != down[1]) {
				arr[curx][cury] = arr[nx][ny];
				curx = nx;
				cury = ny;
			} else {
				arr[curx][cury] = 0;
				break;
			}

		}
		arr[up[0]][up[1]] = -1;
		arr[down[0]][down[1]] = -1;
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dustUpdate() {
		dust = new HashSet<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					dust.add(i * C + j);
				}
			}
		}
	}
}
