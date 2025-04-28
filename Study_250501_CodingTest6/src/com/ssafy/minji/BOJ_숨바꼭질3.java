package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		int[] dp = new int[200000];
		Arrays.fill(dp, -1);
		que.add(N);
		dp[N] = 0;
		int curr, sec;
		int ans = -1;
		
		while(!que.isEmpty()) {
			curr = que.poll();
			sec = dp[curr];
			if(curr == M) {
				ans = dp[curr];
				break;
			}
			
			//!!!!!! 가중치 0인 *2 이동을 먼저 처리해야 한다 !!!!!!
			if(curr * 2 < 200000 && dp[curr * 2] == -1) {
				que.add(curr * 2);
				dp[curr * 2] = sec;
			}
			if(curr - 1 >= 0 && dp[curr - 1] == -1) {
				que.add(curr - 1);
				dp[curr - 1] = sec + 1;
			}
			if(curr + 1 <= 100000 && dp[curr + 1] == -1) {
				que.add(curr + 1);
				dp[curr + 1] = sec + 1;
			}
		}
		
		System.out.println(ans);
	}
}
