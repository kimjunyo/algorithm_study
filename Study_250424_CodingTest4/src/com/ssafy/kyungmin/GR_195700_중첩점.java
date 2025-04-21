import java.io.*;
import java.util.StringTokenizer;

class GR_195700_중첩점 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 크기 1~100
		int N = Integer.parseInt(st.nextToken());
		// 반직선의 개수 1~100000
		int M = Integer.parseInt(st.nextToken());

		int[][] ud = new int[N + 1][N + 1];
		int[][] lr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			switch (dir) {
			case "U":
				for (int j = r; j > 0; j--) {
					ud[j][c]++;
				}
				break;
			case "D":
				for (int j = r; j < N + 1; j++) {
					ud[j][c]++;
				}
				break;
			case "L":
				for (int j = c; j > 0; j--) {
					lr[r][j]++;
				}
				break;
			case "R":
				for (int j = c; j < N + 1; j++) {
					lr[r][j]++;
				}
				break;
			default:
				break;
			}
		}

		long sum = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				sum += ((long) ud[i][j] * (long) lr[i][j]);
			}
		}

		System.out.println(sum);
	}
}