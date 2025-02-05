package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		int remainder = 0;
		long[] cnt = new long[M];
		long answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			sum += Integer.parseInt(st.nextToken());
			remainder = (int)(sum % M);
			if(remainder == 0)
				answer++;
			cnt[remainder]++;
		}
		
		for(int i = 0 ; i < M ; i++) {
			if (cnt[i] > 1)
				answer += cnt[i] * (cnt[i] - 1) / 2;
		}
		
		System.out.println(answer);
	}
}
