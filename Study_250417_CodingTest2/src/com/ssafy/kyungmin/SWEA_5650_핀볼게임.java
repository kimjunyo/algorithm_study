package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5650_핀볼게임 {
	// 상하좌우
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static final int BLACKHOLE = -1;
	static final int BLANK = 0;
	static final int BLOCK_MIN = 1;
	static final int BLOCK_MAX = 5;
	static final int WORMHOLE_MIN = 6;
	static final int WORMHOLE_MAX = 10;

	static int N;
	static int[][] map;
	static Map<Integer, List<int[]>> wormholes;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			max = 0;
			wormholes = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2];
			
			// 출발 위치 or 블랙홀일때 끝
			// 점수 = 벽, 블록에 붇힌 횟수. 웜홀은 X

			for (int i = 0; i < N + 2; i++) {
				map[0][i] = 5;
				map[N + 1][i] = 5;
				map[i][0] = 5;
				map[i][N + 1] = 5;
			}

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= WORMHOLE_MIN && map[i][j] <= WORMHOLE_MAX) {
						wormholes.computeIfAbsent(map[i][j], k -> new ArrayList<>()).add(new int[] { i, j });
					}
				}
			}

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (map[r][c] == BLANK) {
						for (int d = 0; d < 4; d++) {
							simulate(r, c, delta[d][0], delta[d][1]);
						}
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}

	static void simulate(int sr, int sc, int dr, int dc) {
		int score = 0;
		int r = sr;
		int c = sc;
		boolean first = true;

		while (true) {
			if (!first && r == sr && c == sc)
				break;
			first = false;

			int nr = r + dr;
			int nc = c + dc;

			int val = map[nr][nc];
			if (val == BLACKHOLE) break;

			// 블록
			if (val >= BLOCK_MIN && val <= BLOCK_MAX) {
				score++;

				if (val == 1) {
					if (dr == -1) dr = 1;
					else if (dc == 1) dc = -1;
					else if (dr == 1) { dr = 0; dc = -1; }
					else if (dc == -1) { dr = 0; dc = 1; }
				} else if (val == 2) {
					if (dr == 1) dr = -1;
					else if (dc == 1) { dr = 0; dc = -1; }
					else if (dr == -1) { dr = 0; dc = 1; }
					else if (dc == -1) dc = 1;
				} else if (val == 3) {
					if (dr == 1) { dr = 0; dc = -1; }
					else if (dc == -1) { dr = -1; dc = 0; }
					else if (dr == -1) { dr = 0; dc = 1; }
					else if (dc == 1) { dr = 1; dc = 0; }
				} else if (val == 4) {
					if (dr == 1) { dr = 0; dc = 1; }
					else if (dc == 1) { dr = -1; dc = 0; }
					else if (dr == -1) { dr = 0; dc = -1; }
					else if (dc == -1) { dr = 1; dc = 0; }
				} else if (val == 5) {
					dr *= -1;
					dc *= -1;
				}

				r = nr;
				c = nc;
				continue;
			}

			// 웜홀
			if (val >= WORMHOLE_MIN && val <= WORMHOLE_MAX) {
				List<int[]> posList = wormholes.get(val);
				if (posList.get(0)[0] == nr && posList.get(0)[1] == nc) {
					nr = posList.get(1)[0];
					nc = posList.get(1)[1];
				} else {
					nr = posList.get(0)[0];
					nc = posList.get(0)[1];
				}
			}

			r = nr;
			c = nc;
		}

		max = Math.max(max, score);
	}
}
