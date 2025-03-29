package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용_구하기 {
	
	static List<Edge>[] graph;
	static int[] costArr;
	
	private static class Edge{
		int to,cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static int findMinCost(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.cost, e2.cost));
		costArr[start] = 0;
		pq.add(new Edge(start,costArr[start]));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(curr.cost > costArr[curr.to]) continue;
			
			for(Edge next : graph[curr.to]) {
				if(costArr[next.to] > costArr[curr.to] + next.cost) {
					costArr[next.to] = costArr[curr.to] + next.cost;
					pq.add(new Edge(next.to, costArr[next.to]));
				}
			}
		}
		return costArr[end];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		costArr = new int[N+1];
		for(int i=0; i<=N; i++) {
		    graph[i] = new ArrayList<>();
		    costArr[i] = Integer.MAX_VALUE;
		}

		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, cost));
		}
		
		st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int result = findMinCost(start, end); 
		System.out.println(result);            
	}
}
