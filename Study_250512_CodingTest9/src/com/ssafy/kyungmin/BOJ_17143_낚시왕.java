import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int R, C, M;
	static int[][][] map;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1][3];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (d <= 2)
				s %= (R - 1) * 2;
			else
				s %= (C - 1) * 2;

			map[r][c] = new int[] { s, d, z };
		}

		int total = 0;

		for (int i = 1; i <= C; i++) {
			// 1. 낚시: col에서 가장 가까운 상어
			for (int r = 1; r <= R; r++) {
				if (map[r][i][2] != 0) {
					total += map[r][i][2];
					map[r][i] = new int[3];
					break;
				}
			}

			// TODO 다못품

		}

		System.out.println(total);
	}
}
