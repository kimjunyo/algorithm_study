package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P043_1850_최대공약수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long temp = 0;
		if(M > N) {
			temp = N;
			N = M;
			M = temp;
		}
		
//		long n = makeNum(N);
//		long m = makeNum(M);
		while(true) {
			if(N % M == 0) {
				break;
			}else {
				temp = N;
				N = M;
				M = temp % N;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ; i++) {
			sb.append("1");
		}
		System.out.println(sb);
	}
	
}
