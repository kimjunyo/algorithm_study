package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IM대비7_오목 {
	static int[][] board;
	
	private static int[] findWinner(List<int[]> color, int a) {
	    int[] dx = {0, 1, 1, -1}; 
	    int[] dy = {1, 0, 1, 1};

	    for (int[] idx : color) {
	        int row = idx[0];
	        int col = idx[1];

	        for (int i = 0; i < 4; i++) {
	            if (row - dx[i] >= 0 && row - dx[i] < 19 && col - dy[i] >= 0 && col - dy[i] < 19 &&
	                board[row - dx[i]][col - dy[i]] == a) {
	                continue; 
	            }

	            int cnt = 1;
	            for (int p = 1; p < 6; p++) {
	                int nx = row + dx[i] * p;
	                int ny = col + dy[i] * p;

	                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != a) break;
	                cnt++;

	                if (cnt == 5) { 
	                    int prevX = row - dx[i];
	                    int prevY = col - dy[i];
	                    int nextX = row + dx[i] * 5;
	                    int nextY = col + dy[i] * 5;

	                    if ((prevX >= 0 && prevX < 19 && prevY >= 0 && prevY < 19 && board[prevX][prevY] == a) ||
	                        (nextX >= 0 && nextX < 19 && nextY >= 0 && nextY < 19 && board[nextX][nextY] == a)) {
	                        continue; 
	                    }

	                    return new int[]{a, row, col}; 
	                }
	            }
	        }
	    }
	    return new int[]{-1, -1, -1};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> black = new ArrayList<>();
		List<int[]> white = new ArrayList<>();
		
		board = new int[19][19];
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] ==1) black.add(new int[] {i,j});
				if(board[i][j] ==2) white.add(new int[] {i,j});
			}
		}

		int[] result1 = findWinner(black,1);
		int[] result2 = findWinner(white,2);
		
		if(result1[0] == result2[0]) System.out.println("0");
		else {
			int result[] = result1[0]>result2[0] ? result1 : result2;
			System.out.println(result[0]);
			System.out.println((result[1]+1)+" "+(result[2]+1));
		}
	}
}