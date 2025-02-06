package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P006_2018_수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int start = 1;
		int end = 1;
		int sum = 1;
		int cnt = 0;
		
		do{
			if(sum == N) {
				cnt++;
				sum += ++end;
			}else if(sum < N){
				sum += ++end;
			}else {
				sum -= start++;
			}
		}while(end <= N);
		
		System.out.println(cnt);
	}
}
