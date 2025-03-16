package jungol.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_1031_빙고 {

	static int[][] board;
	static int bingo = 0;

	private static void findIdx(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == num) {
					board[i][j] = 0;
					checkBingo(i, j);
					return;
				}
			}
		}
	}

	private static void checkBingo(int i, int j) {
		// 행검사
		int sum = 0;
		for (int c = 0; c < 5; c++) {
			sum += board[i][c];
		}
		if (sum == 0)
			bingo++;

		// 열검사
		sum = 0;
		for (int r = 0; r < 5; r++) {
			sum += board[r][j];
		}
		if (sum == 0)
			bingo++;

		// 대각선
		sum = 0;
		if (i + j == 4) {
			for (int d = 0; d < 5; d++) {
				sum += board[d][4 - d];
			}
			if (sum == 0) bingo++;
		}
		

		// 대각선
		sum = 0;
		if (i == j) {
			for (int d = 0; d < 5; d++) {
				sum += board[d][d];
			}
			if (sum == 0) bingo++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				cnt++;
				findIdx(num);
				if(bingo>=3) {
					System.out.println(cnt);
					return;
				}
				
			}
		}
	}
}
