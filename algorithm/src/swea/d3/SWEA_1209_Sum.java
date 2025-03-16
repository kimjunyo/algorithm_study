package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209_Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int rowSum, max = 0;
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rowSum = 0;
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					rowSum += arr[i][j];		
				}
				max = Math.max(max, rowSum); //행 max
			}
			

		    int colSum;
			for(int j=0; j<100; j++) {
				colSum =0;
				for(int i=0; i<100; i++) {
					colSum += arr[i][j];
				}
				max = Math.max(max, colSum); 
			}
			
			int crossSum1 =0, crossSum2 =0;
			for(int i=0; i<100; i++) {
				crossSum1 += arr[i][i];		
				crossSum2 += arr[i][99-i];
			}
//			
//			int crossSum2 =0;
//			for(int i=0, j=99; i<100 && j>=0; i++, j--) {
//				crossSum2 += arr[i][j];
//			}
			
			max = crossSum1>crossSum2 ? Math.max(max, crossSum1) : Math.max(max, crossSum2);
			System.out.println("#"+T+" "+max);
		}
	}
}
