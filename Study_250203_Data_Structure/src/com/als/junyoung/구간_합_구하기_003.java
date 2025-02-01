package com.als.junyoung;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		int[] S = new int[N+1];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			sum += A[i];
			S[i+1] = sum;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			System.out.println(S[second] - S[first-1]);
		}
	}
}
