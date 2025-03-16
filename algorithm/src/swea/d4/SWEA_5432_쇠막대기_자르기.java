package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5432_쇠막대기_자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			int cnt =0, sum =0, right =0;
			char[] arr = br.readLine().toCharArray();
			for(int i=0; i<arr.length; i++) {
				if(arr[i]=='(' && arr[i+1] == ')') { //레이저
					sum+=cnt;
					i++;
				}else if(arr[i] == '(' )cnt++;
				 else  cnt--;
				
				if(arr[i] == ')' && arr[i-1] == ')' ) right++;
			}
			System.out.println("#"+tc+" "+(sum+right));
		}
	}
}