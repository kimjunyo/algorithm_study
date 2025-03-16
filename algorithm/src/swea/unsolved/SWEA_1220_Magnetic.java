package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 7;
		int T = 10;
		int[][] arr = new int[N][N];
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(arr));
			
			
			for(int j=0; j<N; j++) {
				for(int i=0; i<N; i++) {
					if(arr[i][j] == 1) {
						
					}
					
					
					
				}
			}
			
			
			
			
		}//tc for문
	}
}
