package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물_수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j = 0; j<N; j++) {
					arr[i][j] = input.charAt(j)-'0';
					sum+= arr[i][j];
				}
			}
			
			int sub = 0;
			for(int i=0; i<N; i++) {
				int move = i<= (N/2) ? (N/2-i) : i-(N/2);
				int j =0;
				int skip = N-(move*2);
				while(j<move) {
					sub += arr[i][j] + arr[i][j+move+skip];
					j++;
				}
			}
			System.out.println("#" + tc + " " + (sum-sub));
		}
	}
}
