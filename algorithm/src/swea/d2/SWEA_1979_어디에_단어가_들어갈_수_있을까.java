package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_어디에_단어가_들어갈_수_있을까{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int[][] board;
	static int[][] board2;
	
	private static int check(int[][] arr) {
		int possible = 0;
		for(int i=1; i<N+2; i++) {
			for(int j=1; j<N+2-K; j++) {
				int cnt = 1;
				if(arr[i][j]==1) {
					while(cnt<K) {
						if(arr[i][j+cnt] == 1) cnt++;
						else {
							j+=cnt; //건너뛰기
							break;
						}
					}
					if(cnt==K && arr[i][j+cnt]==0 && arr[i][j-1]==0) {
						possible++;
					}
				}
			}
		}
		return possible;
	}
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N+2][N+2];
			board2 = new int[N+2][N+2];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					board2[j][i] = board[i][j];
				}
			} 
			int result = check(board) + check(board2);
			System.out.println("#"+tc+" "+result);
		}
	}
}