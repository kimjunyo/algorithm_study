package com.als.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P003_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sb.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(sb.readLine());
		int[] sums = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			sums[i] += sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(sb.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sums[end] - sums[start-1]);
		}
		
	}
}