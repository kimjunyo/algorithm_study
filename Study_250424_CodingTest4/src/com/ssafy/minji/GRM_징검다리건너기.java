package com.ssafy.minji;

import java.io.*;
import java.util.*;

class GRM_징검다리건너기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] dp = new long[N + 1];
		dp[1] = Long.parseLong(st.nextToken());
		dp[2] = Long.parseLong(st.nextToken());
		long curr, n1, n2, n3;
		for(int i = 3 ; i <= N; i++){
			curr = Long.parseLong(st.nextToken());
			n1 = dp[i-3] + curr;
			n2 = dp[i-2] + curr;
			n3 = dp[i-1] + curr;
			dp[i] = Math.min(n1, Math.min(n2, n3));
		}
		long ans = Math.min(dp[N-2], Math.min(dp[N-1], dp[N]));
		System.out.println(ans);
	}
}