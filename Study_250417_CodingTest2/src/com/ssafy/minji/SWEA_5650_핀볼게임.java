package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {
	static int N;
	static int[][] map;
	static Map<Integer, int[]> warm;
	static Map<Character, int[]> dir;
	static char curDir;
	static int bounce;
	static int[] start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			warm = new HashMap<>();

			int val;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					val = map[i][j];
					if (val >= 6 && val <= 10) {
						if (!warm.containsKey(val)) {
							warm.put(val, new int[] { i, j });
						} else {
							val *= 2;
							warm.put(val, new int[] { i, j });
							map[i][j] = val;
						}
					}
				}
			}

			dir = new HashMap<>();
			dir.put('U', new int[] { -1, 0 });
			dir.put('D', new int[] { 1, 0 });
			dir.put('L', new int[] { 0, -1 });
			dir.put('R', new int[] { 0, 1 });
			char[] dirs = new char[] { 'U', 'D', 'L', 'R' };

			int r, c;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						start = new int[] { i, j };
						r = i;
						c = j;
						for (int d = 0; d < 4; d++) {
							bounce = 0;
							curDir = dirs[d];
							changeDir(r, c);
							if (max < bounce) {
								max = bounce;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	static void changeDir(int r, int c) {
		int[] temp;
		while (true) {
			r += dir.get(curDir)[0];
			c += dir.get(curDir)[1];
			if (r < 0) {
				curDir = 'D';
				bounce++;
			} else if (c < 0) {
				curDir = 'R';
				bounce++;
			} else if (r >= N) {
				curDir = 'U';
				bounce++;
			} else if (c >= N) {
				curDir = 'L';
				bounce++;
			} else if (map[r][c] == -1 || (r == start[0] && c == start[1])) {
				return;
			} else if (map[r][c] == 0) {
				continue;
			} else if (map[r][c] == 1) {
				if (curDir == 'U') {
					curDir = 'D';
				} else if (curDir == 'D') {
					curDir = 'R';
				} else if (curDir == 'L') {
					curDir = 'U';
				} else {
					curDir = 'L';
				}
				bounce++;
			} else if (map[r][c] == 2) {
				if (curDir == 'U') {
					curDir = 'R';
				} else if (curDir == 'D') {
					curDir = 'U';
				} else if (curDir == 'L') {
					curDir = 'D';
				} else {
					curDir = 'L';
				}
				bounce++;
			} else if (map[r][c] == 3) {
				if (curDir == 'U') {
					curDir = 'L';
				} else if (curDir == 'D') {
					curDir = 'U';
				} else if (curDir == 'L') {
					curDir = 'R';
				} else {
					curDir = 'D';
				}
				bounce++;
			} else if (map[r][c] == 4) {
				if (curDir == 'U') {
					curDir = 'D';
				} else if (curDir == 'D') {
					curDir = 'L';
				} else if (curDir == 'L') {
					curDir = 'R';
				} else {
					curDir = 'U';
				}
				bounce++;
			} else if (map[r][c] == 5) {
				if (curDir == 'U') {
					curDir = 'D';
				} else if (curDir == 'D') {
					curDir = 'U';
				} else if (curDir == 'L') {
					curDir = 'R';
				} else {
					curDir = 'L';
				}
				bounce++;
			} else if (map[r][c] >= 6 && map[r][c] <= 10) {
				temp = warm.get(map[r][c] * 2);
				r = temp[0];
				c = temp[1];
			} else if (map[r][c] >= 12) {
				temp = warm.get(map[r][c] / 2);
				r = temp[0];
				c = temp[1];
			}
		}
	}
}
