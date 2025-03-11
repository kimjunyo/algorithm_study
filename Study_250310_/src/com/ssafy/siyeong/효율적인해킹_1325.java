package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹_1325 {
	static int N;
	static int M;
	static List<Integer>[] list;
	static int [] counts;
	static boolean [] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}
		counts = new int[N + 1];
		int maxCount = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			counts[i] = hackingBFS(i);
			maxCount = Math.max(maxCount, counts[i]);
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (counts[i] == maxCount) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString().trim());
		
	}
	
	
	private static int hackingBFS(int n) {
		visited[n] = true;
		int count = 1;
		q.add(n);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int next : list[x]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					count++;
				}
			}
		}
		return count;
		
	}
}

//	private static int hackingDFS(int n) {
//		visited[n] = true;
//		int count = 1;
//		for (int next : list[n]) {
//			if (!visited[next]) {
//				count += hacking(next);
//			}
//		}
//		return count;
//	}
