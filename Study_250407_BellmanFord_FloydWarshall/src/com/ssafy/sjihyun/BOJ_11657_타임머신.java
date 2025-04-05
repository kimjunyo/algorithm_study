package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_11657_타임머신 {
	
	static List<Edge> edges;
	static int N;
	
	private static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static void bellmanFord(int start) {
		long[] dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		
		for(int i=2; i<N+1; i++) {
			for(Edge edge : edges) {
				if(dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
		}
		
		for(Edge edge : edges) {
			if(dist[edge.from] != Long.MAX_VALUE && dist[edge.from] + edge.cost < dist[edge.to]) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int i=2; i<N+1; i++) {
			System.out.println(dist[i] != Long.MAX_VALUE ? dist[i] : -1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, cost));
		}
		bellmanFord(1);
	}
}
