package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄_세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		int[] inDegree = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			inDegree[B]++;
			graph[A].add(B);
		}
		
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++){
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append(" ");
			for(int node : graph[n]) {
				inDegree[node]--;
				if(inDegree[node] ==0) {
					q.offer(node);
				}
			}
		}
		System.out.println(sb);
	}
}
