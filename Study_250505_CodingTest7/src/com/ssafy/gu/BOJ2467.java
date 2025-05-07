package com.ssafy.gu

import java.util.*;
import java.io.*;

public class BOJ2467{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N ; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    int l = 0;
    int r = N-1;

    int minAbs = Integer.MAX_VALUE;
    int[] ans = new int[2];
    while (l < r) {
      int sum = arr[l] + arr[r];
      if (Math.abs(sum) < minAbs) {
        minAbs = Math.abs(sum);
        ans[0] = arr[l];
        ans[1] = arr[r];
      }
      if (sum > 0) r--;
      else l++;
    }
    for (int v : ans) System.out.print(v+" ");
  }
}
