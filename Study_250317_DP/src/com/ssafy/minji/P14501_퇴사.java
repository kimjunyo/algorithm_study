package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501_퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		int[] T = new int[N];
		int[] P = new int[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[N];
		if(T[N-1] == 1) {
			DP[N-1] = P[N-1];
		}
		for(int i = N-2 ; i >= 0 ; i--	) {
			if(i + T[i] < N && DP[i + T[i]] + P[i] > DP[i + T[i] - 1]) {
				DP[i] = DP[i + T[i]] + P[i];
			}else {
				DP[i] = DP[i+1];
			}
		}
		
		System.out.println(DP[0]);
		
		
	}
}
