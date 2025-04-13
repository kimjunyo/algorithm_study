import java.io.*;
import java.util.StringTokenizer;

class GR_88520_놀이공원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			st = new StringTokenizer(br.readLine());
			// 공터 크기 1~100
			int N = Integer.parseInt(st.nextToken());
			// 구매할 땅의 크기 1~N
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 0 -> 비어있고
					// 1 -> 폐기물있음
					map[i][j] = st.nextToken().equals("1") ? 1 : 0;
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N - K + 1; i++) {
				for (int j = 0; j < N - K + 1; j++) {
					int sum = getSum(min, map, K, i, j);
					if (min > sum) {
						min = sum;
					}
				}
			}

			System.out.println(min);
		}
	}

	static int getSum(int currentMin, int[][] map, int K, int startR, int startC) {
		int sum = 0;
		for (int i = startR; i < startR + K; i++) {
			for (int j = startC; j < startC + K; j++) {
				sum += map[i][j];
				if (sum > currentMin) {
					return currentMin;
				}
			}
		}
		return sum;
	}
}