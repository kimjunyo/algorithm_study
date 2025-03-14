package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722_순열의순서 {
	static int N;
	static int[] givenArr;
	static int[] arr;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		if(p == 1) {
			K = Integer.parseInt(st.nextToken());
		}else {
			arr = new int[N];
			givenArr = new int[N];
			for(int i = 0 ; i < N ;i++) {
				givenArr[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
}
