package com.ssafy.yeook;

import java.util.*;
import java.io.*;

public class 최소비용구하기_1916 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도시의 갯수
		int n = Integer.parseInt(st.nextToken());
		// 버스 갯수.
		int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		// 각 도시의 인접 정점들 저장.
		List<int[]>[] adjs = new ArrayList[n + 1];
		// 최단거리저장 테이블
		int[] shortestpath = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			adjs[i] = new ArrayList<int[]>();
			shortestpath[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjs[a].add(new int[] { b, w }); // 인접 정점번호, 비용 저장.
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작 정점.
		int end = Integer.parseInt(st.nextToken()); // 도착정점.

		shortestpath[start] = 0;

		Set<Integer> visit = new HashSet<>();
		PriorityQueue<int[]> unvisit = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		unvisit.add(new int[] { start, 0 });

		while (!unvisit.isEmpty()) {
			int[] deque = unvisit.poll(); // {도시번호, 출발지부터 현재 도시까지의 최단거리}
			if (visit.contains(deque[0]))
				continue;
			visit.add(deque[0]);
			// 현재 도시에 연결된 정점들 순회하며 최단거리 테이블 업데이트.
			for (int[] adj : adjs[deque[0]]) {
				if (!visit.contains(adj[0]) && (shortestpath[deque[0]] != Integer.MAX_VALUE)
						&& (shortestpath[adj[0]] > shortestpath[deque[0]] + adj[1])) {
					shortestpath[adj[0]] = shortestpath[deque[0]] + adj[1];
					unvisit.add(new int[] { adj[0], shortestpath[adj[0]] });

				}

			}

		}
		System.out.println(shortestpath[end]);

	}// main

}