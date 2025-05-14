package com.ssafy.gu;

import java.util.*;
import java.io.*;

public class BOJ2023{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] degree = new int[N+1];
    boolean[] visited = new boolean[N+1];
    List<Integer>[] adj = new ArrayList[N+1];

    for (int i = 0; i < N+1; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      int prev = 0;
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      for (int j = 0; j < cnt; j++) {
        int singer = Integer.parseInt(st.nextToken());
        adj[prev].add(singer);
        degree[singer]++;
        prev = singer;
      }  
    }
    
    Queue<Integer> q = new ArrayDeque<>();
    Queue<Integer> ans = new ArrayDeque<>();
    q.add(0);
    visited[0] = true;
    while (!q.isEmpty()) {
      int curr = q.poll();
      ans.add(curr);
      for (int i = 0; i < adj[curr].size(); i++) {
    	  degree[adj[curr].get(i)]--;
      }
      for (int i = 1; i < N+1; i++) {
        if (degree[i] > 0 || visited[i]) continue;
        q.add(i);
        visited[i] = true;
      }

    }
    
    if (ans.size() == N+1) {
    	ans.poll();
    	for (int i = 0; i < N; i++) {
    		System.out.println(ans.poll());
    	}
    } else {
    	System.out.println(0);
    }    
  }
}
