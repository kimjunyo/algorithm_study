package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_1766_문제집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		int[] inDegree = new int[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			inDegree[B]++;
			graph[A].add(B);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i] ==0) pq.offer(i);
		}
		while(!pq.isEmpty()) {
			int node = pq.poll();
			sb.append(node).append(" ");
			for(int n : graph[node]) {
				inDegree[n]--;
				if(inDegree[n] ==0) {
					pq.offer(n);
				}
			}
		}
		System.out.println(sb);
	}
}
