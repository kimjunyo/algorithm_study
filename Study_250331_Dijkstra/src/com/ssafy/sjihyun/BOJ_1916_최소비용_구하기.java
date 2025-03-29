package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용_구하기 {
	static List<int[]>[] graph;
	static int[] costArr;
	
	private static void findMinCost(int sNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int currNode = sNode, currCost = 0;
		pq.add(new int[] {currNode, currCost});
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			currNode = info[0]; currCost = info[1];
			
			if(currCost > costArr[currNode]) continue;
			
			for(int[] n : graph[currNode]) {
				int nextNode = n[0], nextCost = n[1] + currCost;
				
				if(nextCost < costArr[nextNode]) {
					costArr[nextNode] = nextCost;
					pq.offer(new int[] {nextNode, nextCost});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수 
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 
		
		graph = new ArrayList[N+1];
		costArr = new int[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			costArr[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new int[] {v, cost});
		} //그래프 완
		
		st = new StringTokenizer(br.readLine());
		int sNode = Integer.parseInt(st.nextToken());
		int eNode = Integer.parseInt(st.nextToken());
		
		if(sNode == eNode) {
			System.out.println(0);
			return;
		}
		
		findMinCost(sNode);
		System.out.println(costArr[eNode]);
	}
}
