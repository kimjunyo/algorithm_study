package com.als.junyoung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 구간_합_구하기_2_004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] S = new int[N*N+1];
		
		int idxS = 1;
		int sum = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int X = Integer.parseInt(st.nextToken());
				sum+=X;
				S[idxS++] = sum;
			}
		}
		
		for(int i=0; i<M; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			for(int j=X1-1; j<X2; j++) {
				sum+=S[N*(j)+Y2]-S[N*(j)+Y1-1];
			}
			
			System.out.println(sum);
		}
	}
}
