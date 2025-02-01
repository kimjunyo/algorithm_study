package com.als.junyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 평균_구하기_002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int max = -1;
		
		for(int i = 0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			if (temp > max) max = temp;
		}
		
		System.out.println(sum*1.0/N/max*100);
	}
}
