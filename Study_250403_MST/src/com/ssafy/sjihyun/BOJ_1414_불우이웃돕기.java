package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_1414_불우이웃돕기 {
	
	static int[] node;
	
	private static class Edge{
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static boolean unionFind(int numA, int numB) {
		int rootA = findNode(numA);
		int rootB = findNode(numB);
		
		if(rootA == rootB) return false;
		if(rootA < rootB) node[rootB] = rootA;
		else node[rootA] = rootB;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Edge> graph  = new ArrayList<>();
		node = new int[N];
		Arrays.setAll(node,  i->i);
		
		int totalLen = 0;
		for(int from=0; from<N; from++){
			String input = br.readLine();
			for(int to=0; to<N; to++) {
				char alphabet = input.charAt(to);
				if(alphabet == '0') continue;
				
				int cost = (alphabet >= 'A' &&alphabet <= 'Z') ? alphabet - 'A'+27 : alphabet - 'a'+ 1;
				graph.add(new Edge(from, to, cost));
				totalLen += cost;
			}
		}
		
		graph.sort((e1,e2) -> Integer.compare(e1.cost, e2.cost));
		
		int minLen = 0, cnt = 0;
		boolean isPossible = false;
		for(Edge e : graph) {
			if(unionFind(e.from, e.to)) {
				minLen += e.cost;
				cnt++;
				if(cnt == N-1) {
					isPossible = true;
					break;
				}
			}
		}
		
		if(cnt==N-1) isPossible = true;
		System.out.println( isPossible ? (totalLen-minLen) : -1);
	}
}
