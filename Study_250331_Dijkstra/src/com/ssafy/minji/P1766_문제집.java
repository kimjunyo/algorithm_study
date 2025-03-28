package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1766_문제집 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adj = new ArrayList[N + 1];
		for(int i = 0 ; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] inCnt = new int[N + 1];
		int from;
		int to;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			inCnt[to]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for(int i = 1 ; i < N + 1 ; i++) {
			if(inCnt[i] == 0) {
				pq.add(i);
			}
		}
		
		int curr;
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			curr = pq.poll();
			sb.append(curr).append(" ");
			
			for(int i : adj[curr]) {
				if(--inCnt[i] == 0) {
					pq.add(i);
				}
			}
		}
		System.out.println(sb);
	}
}
