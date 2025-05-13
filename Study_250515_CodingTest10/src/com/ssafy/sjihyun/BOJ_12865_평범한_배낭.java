package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_12865_평범한_배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=K; j++) {
        		if(j<weight[i]) dp[i][j] = dp[i-1][j];
        		else dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j-weight[i]]);
        	}
        }
        System.out.println(dp[N][K]);
    }
}
