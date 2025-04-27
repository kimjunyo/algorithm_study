import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class GR_152115_현대모비스예선주차시스템 {
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] parkingLot;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1~R,C~2000
		// R줄, 길이 C문자열
		// 0 -> 주차 가능
		// 2 -> 장애인 전용 주차 구역
		// 1 -> 기주차
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parkingLot = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				parkingLot[i][j] = Integer.parseInt(st.nextToken());
				if (parkingLot[i][j] == 1)
					visited[i][j] = true;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (parkingLot[i][j] != 1 && !visited[i][j]) {
					int score = 0;

					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { i, j });
					visited[i][j] = true;

					while (!q.isEmpty()) {
						int[] coor = q.poll();

						int cr = coor[0];
						int cc = coor[1];

						score += (parkingLot[cr][cc] == 0 ? 1 : -2);

						for (int d = 0; d < dr.length; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && parkingLot[nr][nc] != 1) {
								if (!visited[nr][nc]) {
									q.offer(new int[] { nr, nc });
									visited[nr][nc] = true;
								}
							}
						}
					}
					if (max < score) {
						max =  score;
					}
				}
			}
		}
		
		if (max < 0) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
	}
}