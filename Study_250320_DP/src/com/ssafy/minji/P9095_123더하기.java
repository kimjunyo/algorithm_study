package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095_123더하기 {
	static int result;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			
			result = 0;
			sumCnt(0);
			System.out.println(result);
		}
	}
	
	static void sumCnt(int sum) {
		if(sum >= N) {
			if(sum == N) {
				result++;
			}
			return;
		}
		for(int i = 1 ; i <= 3 ; i++) {
			sumCnt(sum + i);
		}
	}
}
