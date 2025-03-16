package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9490_풍선팡 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] field = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1}; 
			
			int maxSum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int P = field[i][j];
					int sum = P;
					for(int d = 0; d<4; d++) {
						for(int p = 1; p<=P; p++) {
							int nx = i + dx[d]*p;
							int ny = j + dy[d]*p;
							
							if( nx<0 || nx>= N || ny<0 || ny>= M) continue;
							sum += field[nx][ny];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			System.out.println("#"+tc+" "+maxSum);
		}
	}
}