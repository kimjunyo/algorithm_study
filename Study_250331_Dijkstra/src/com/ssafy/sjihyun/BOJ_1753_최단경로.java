package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {

	static List<Edge>[] graph;
	static int[] costArr;
	
	private static class Edge{
		int to, cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static void findMinCost(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->Integer.compare(e1.cost,e2.cost));
		costArr[start] = 0;
		pq.offer(new Edge(start, costArr[start]));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(curr.cost > costArr[curr.to]) continue;
			
			for(Edge next : graph[curr.to]) {
				if(costArr[next.to] > costArr[curr.to] + next.cost) {
					costArr[next.to] = costArr[curr.to] + next.cost;
					pq.offer(new Edge(next.to, costArr[next.to]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		costArr = new int[V+1];
		for(int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<>();
			costArr[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to,cost));
		}
		
		findMinCost(K);
		for(int i=1; i<=V; i++) {
		    sb.append(costArr[i] == Integer.MAX_VALUE ? "INF" : costArr[i]).append("\n");
		}
		System.out.println(sb);
	}
}