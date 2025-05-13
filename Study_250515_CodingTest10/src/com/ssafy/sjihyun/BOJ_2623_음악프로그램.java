package com.ssafy.sjihyun;

import java.util.*;
import java.io.*;

public class BOJ_2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v;
			for(int j=1; j<num; j++) {
				v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				inDegree[v]++;
				u = v;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) q.offer(i);
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node).append("\n");
			cnt++;
			for(int n : graph[node]) {
				inDegree[n]--;
				if(inDegree[n] == 0) q.offer(n);
			}
		}
		if(cnt==N) System.out.println(sb);
		else System.out.println(0);
	}
}
