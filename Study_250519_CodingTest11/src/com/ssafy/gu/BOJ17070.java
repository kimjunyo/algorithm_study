package com.ssafy.gu;

import java.util.*;
import java.io.*;

public class BOJ17070{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] room = new int[N+1][N+1];
    for (int i = 1; i < N+1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j < N+1; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][][] dp = new int[N+1][N+1][3];
    dp[1][2][1] = 1;
    for (int i = 1; i < N+1; i++) {
      for (int j = 3; j < N+1; j++) {
        if (room[i][j] == 0) {
          if (room[i-1][j] == 0 && room[i][j-1] == 0) {
            dp[i][j][0] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
          }
          dp[i][j][1] = dp[i][j-1][0] + dp[i][j-1][1];
          dp[i][j][2] = dp[i-1][j][0] + dp[i-1][j][2];
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < 3; i++) {
      ans += dp[N][N][i];
    }
    System.out.println(ans);
  }
}
