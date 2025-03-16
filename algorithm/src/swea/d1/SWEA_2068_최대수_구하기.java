package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2068_최대수_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		//System.out.println(T);
		
		for(int tc =1; tc<=T; tc++) {
			String[] input = br.readLine().split(" ");
			int size = input.length;
			int[] arr = new int[size];
			for(int i=0; i<size; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			//System.out.println(Integer.parseInt(st.nextToken()));
			//5 3 4 6 1
			//System.out.println(Arrays.toString(arr));
			//버블 정렬 이용하기
			for(int i=size-1; i>0; i--) {
				for(int j=0; j<i; j++) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
			//System.out.println(Arrays.toString(arr));
			
			System.out.println("#"+tc+" "+arr[size-1]);
		}
	}
}
