package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1206_View {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer("");
		for(int tc = 1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[num];
			for(int i=0; i<num; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			int[] check = new int[num-4];
			int idx=0;
			for(int i =2; i<num-2; i++) {
				int left = arr[i]-arr[i-2] < arr[i]-arr[i-1] ? arr[i]-arr[i-2] : arr[i]-arr[i-1];
				int right = arr[i]-arr[i+2] < arr[i]-arr[i+1] ? arr[i]-arr[i+2] : arr[i]-arr[i+1];
				check[idx++] = left < right ? left : right;
			}
			
			int sum =0;
			for(int i=0; i<check.length; i++) {
				if(check[i]>0) {
					sum+= check[i];
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
