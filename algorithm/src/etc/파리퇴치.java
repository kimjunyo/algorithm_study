package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치 {
	//동서남북 2시 5시 7시 11시
	static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0; j<N; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
				 }
			} //받았고
			
			//십자가
			int sum = 0;
			for(int i=0; i<N; i++) {
				 for(int j=0; j<N; j++) {
					 
					 int cnt1 =0; int cnt2 = 0;
					 
					 for(int d =0; d<4; d++) {
						 for(int p=1; p<M; p++) {
							 
							 int nx = dx[d]*p + i;
							 int ny = dy[d]*p + j;
							 
							 if(0<= nx && nx < N && 0<= ny && ny < N) {
								 cnt1 += arr[nx][ny];
							 }
						 }
					 }
					 cnt1 += arr[i][j];
					 
					 for(int d =4; d<8; d++) {
						 for(int p=1; p<M; p++) {
							 int nx = dx[d]*p + i;
							 int ny = dy[d]*p + j;
							 if(0<= nx && nx < N && 0<= ny && ny < N) {
								 cnt2 += arr[nx][ny];
							 }
						 }
					 }
					 cnt2 += arr[i][j];
					 
					 int max = Math.max(cnt1, cnt2);
					 sum = Math.max(sum,max);
				 }
			} 

			
			System.out.println(sum);
		}

	}//
}
