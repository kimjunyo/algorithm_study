package com.ssafy.gu;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] edgeCnt = new int[N+1];
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int prior = sc.nextInt();
			int later = sc.nextInt();
			adj[prior].add(later);
			edgeCnt[later]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if (edgeCnt[i] == 0) pq.add(i);
		}
		
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			System.out.print(curr + " ");
			
			for (int v : adj[curr]) {
				if (--edgeCnt[v] != 0) continue;
				pq.add(v);
			}
		}
	}
}
