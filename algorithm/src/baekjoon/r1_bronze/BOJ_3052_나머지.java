package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052_나머지 {
	//입력 숫자 : 10개
	//100보다 작거나 같고, 음이 아닌 정수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[42];
		int cnt =0;
		
		for(int i=0; i<10; i++) {
			int cal = Integer.parseInt(br.readLine()) % 42;
			arr[cal] =true;		
		}
		
		for(int i=0; i<42; i++) {
			if(arr[i]) 
				cnt++;
		}
		System.out.println(cnt);
	}
}
