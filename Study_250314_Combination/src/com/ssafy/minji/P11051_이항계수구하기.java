package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051_이항계수구하기 {
	// ????
	// (n C k) = (n-1 C k-1) + (n-1 C k)

	static int N;
	static int K;
	static long[][] dp;	// ????? 나는 이걸 도무지 모르겠소

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K || K == 0) {
			System.out.println(1);
			return;
		}

		dp = new long[N + 1][K + 1];

	}

	static void calc(int idxN, int idxK) {
		
	}
}
