package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_14567_선수과목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		int[] result = new int[N+1];
		int[] inDegree = new int[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegree[b]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) q.offer(i);
		}
		
		int order = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int n = q.poll();
				result[n] = order;
				
				for(int node : graph[n]) {
					inDegree[node]--;
					if(inDegree[node] == 0) q.offer(node);
				}
			}
			order++;
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
