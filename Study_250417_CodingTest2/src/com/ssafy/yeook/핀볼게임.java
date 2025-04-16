package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 핀볼게임 {
	static int n, max;
	static int[][] arr;
	static int[] warmholl1, warmholl2; //
	static int[] dx = { -1, 1, 0, 0 };// 상하좌우.
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= cases; t++) {

			n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			arr = new int[n][n];
			warmholl1 = new int[11];
			warmholl2 = new int[11];
			Arrays.fill(warmholl1, -1);
			Arrays.fill(warmholl2, -1);

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] >= 6 && arr[i][j] <= 10) {
						if (warmholl1[arr[i][j]] == -1)
							warmholl1[arr[i][j]] = i * n + j;
						else {
							warmholl2[arr[i][j]] = i * n + j;

						}
					}
				}
			}
			max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							max = Math.max(max, game(i, j, d));

						}
					}
				}
			} // arr
			System.out.println("#" + t + " " + max);

		} // tc

	}// main

	static int game(int x, int y, int d) {
		int firstx = x;
		int firsty = y;
		int count = 0;
		outer: while (true) {
			for (int k = 1; k <= n; k++) {
				int nx = x + dx[d] * k;
				int ny = y + dy[d] * k;
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 5) {
					count++;
					d = reverse(d);
					x = nx;
					y = ny;
					break;
				}
				if (nx == firstx && ny == firsty || arr[nx][ny] == -1) {
					break outer;
				}

				if (arr[nx][ny] >= 1 && arr[nx][ny] <= 4) {
					count++;
					d = hitBlock(arr[nx][ny], d);
					x = nx;
					y = ny;
					break;
				}
				if (arr[nx][ny] >= 6 && arr[nx][ny] <= 10) {
					if (warmholl1[arr[nx][ny]] == nx * n + ny) {
						x = warmholl2[arr[nx][ny]] / n;
						y = warmholl2[arr[nx][ny]] % n;
						break;
					} else {
						x = warmholl1[arr[nx][ny]] / n;
						y = warmholl1[arr[nx][ny]] % n;
						break;
					}
				}

			} // for : k

		}
		return count;
	}

	static int hitBlock(int blockNum, int direction) {
		if (blockNum == 1) {
			if (direction == 3 || direction == 0)
				return reverse(direction);
			if (direction == 2)
				return 0;
			if (direction == 1)
				return 3;
		}
		if (blockNum == 2) {
			if (direction == 1 || direction == 3)
				return reverse(direction);
			if (direction == 0)
				return 3;
			if (direction == 2)
				return 1;
		}
		if (blockNum == 3) {
			if (direction == 1 || direction == 2)
				return reverse(direction);
			if (direction == 3)
				return 1;
			if (direction == 0)
				return 2;
		}
		if (blockNum == 4) {
			if (direction == 2 || direction == 0)
				return reverse(direction);
			if (direction == 3)
				return 0;
			if (direction == 1)
				return 2;
		}

		return -1;
	}

	// 방향 반대로 바꾸는 메서드
	static int reverse(int direction) {
		if (direction == 0)
			return 1;
		else if (direction == 1)
			return 0;
		else if (direction == 2)
			return 3;
		else if (direction == 3)
			return 2;
		return -1;
	}

}