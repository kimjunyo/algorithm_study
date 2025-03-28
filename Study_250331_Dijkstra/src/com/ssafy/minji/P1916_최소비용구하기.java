package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 엣지가 다른 문제에 있삼 ~~~
//class Edge implements Comparable<Edge> {
//	int to;
//	int cost;
//
//	public Edge(int to, int cost) {
//		this.to = to;
//		this.cost = cost;
//	}
//
//	@Override
//	public int compareTo(Edge o) {
//		return this.cost - o.cost;
//	}
//}

public class P1916_최소비용구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		List<Edge>[] adj = new ArrayList[N + 1];
		for(int i = 0 ; i < N + 1 ; i++	) {
			adj[i] = new ArrayList<>();
		}
		
		int u;
		int v;
		int w;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(S, 0));
		dist[S] = 0;
		
		Edge e;
		while(!pq.isEmpty()){
			e = pq.poll();
			
			if(dist[e.to] < e.cost) {
				continue;
			}
			
			for(Edge next : adj[e.to]) {
				if(dist[next.to] > dist[e.to] + next.cost) {
					dist[next.to] = dist[e.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
		System.out.println(dist[E]);
	}
}
