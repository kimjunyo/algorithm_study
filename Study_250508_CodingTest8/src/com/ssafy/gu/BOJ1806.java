package com.ssafy.gu;

import java.util.*;
import java.io.*;

public class BOJ1806{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int s = 0;
    int e = 0;
    int preSum = 0;
    int minLen = 100000;
    
    while (e < N || s < N) {
      if (preSum < S) {
        if (e == N) break;
        preSum += arr[e++];
      } else {
        minLen = Math.min(minLen, e-s);
        preSum -= arr[s++];
      }
    }
    if (minLen == 100000) minLen = 0;
    System.out.println(minLen);
  }
}
