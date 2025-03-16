package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1984_중간_평균값_구하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] input = br.readLine().split(" ");
			
			double[] arr = new double[10];
			for(int i=0; i<10; i++){
				arr[i] = Integer.parseInt(input[i]);
			}
			
			//버블정렬
			for(int i=9; i>0; i--) {
				for(int j=0; j<i; j++) {
					if(arr[j]>arr[j+1]) {
						double temp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j]= temp;
					}
				}
			} 
			double avg = 0;
			for(int i=1; i<9; i++)
				avg += arr[i];
			System.out.println("#"+tc+" "+Math.round(avg/8));
		}
	}
}
