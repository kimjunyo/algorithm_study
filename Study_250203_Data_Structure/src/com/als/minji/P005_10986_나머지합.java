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
		
		int[] nums = new int[N + 1];
		int[] sums = new int[N + 1];
		int[] remainder = new int[M];
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i < N + 1 ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sums[i] = (sums[i - 1] + nums[i]) % M;
			if(sums[i] == 0)
				answer++;
			remainder[sums[i]]++;
		}
		
		for(int i = 0 ; i < M ; i++) {
			answer += remainder[i] * (remainder[i] - 1) / 2;
		}
		
		System.out.println(answer);
		
	}
}
