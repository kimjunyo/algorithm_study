import java.io.BufferedReader;
import java.io.InputStreamReader;

// 다 못품
public class BOJ_2239_스도쿠 {
	static int[][] arr = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		recur(0, 0);
	}

	static void recur(int row, int col) {
		// 마지막 줄
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int[] rows : arr) {
				for (int num : rows) {
					sb.append(num);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			return;
		}

		int nr = col == 8 ? row + 1 : row;
		int nc = col == 8 ? 0 : col + 1;

		if (arr[row][col] != 0) {
			recur(nr, nc);
		} else {
			
		}
	}
}
