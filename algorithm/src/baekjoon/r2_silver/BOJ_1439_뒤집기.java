package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt0 = 0, cnt1 = 0, idx = 0;
		String input = br.readLine();
		while(idx < input.length()) {
			if(input.charAt(idx)=='0') {
				while(idx<input.length() && input.charAt(idx)=='0') {
					idx++;
				}
				cnt0++;
				
			}else if(input.charAt(idx)=='1') {
				while(idx<input.length() && input.charAt(idx)=='1') {
					idx++;
				}
				cnt1++;
			}
		}
		System.out.println(Math.min(cnt1, cnt0));
	}
}
