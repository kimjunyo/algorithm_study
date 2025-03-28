package com.ssafy.yeook;

import java.util.*;
import java.io.*;

public class 최단경로_1753 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());// 정점의 갯수.
		int e = Integer.parseInt(st.nextToken());// 간선의 갯수
		int s = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()); // 시작 정점.
		int[] shortestpath = new int[v + 1];// 시작정점에서 해당 해당 정점까지의 최단거리 저장.

		// 하나의 정점(인덱스)에서 연결된 인접 정점의 번호와 거리 저장.
		List<int[]>[] adjs = new ArrayList[v + 1];
		// 하나의 정점(인덱슬)에서 연결된 인접 정점의 번호둘.
		Set<Integer>[] adjsSet = new HashSet[v + 1];

		//
		for (int i = 1; i <= v; i++) {
			adjs[i] = new ArrayList<int[]>();// 인접정접저장할 리스트 생성.
			adjsSet[i] = new HashSet<Integer>(); // 인접정점저장할 셋 생성
			shortestpath[i] = Integer.MAX_VALUE; // 모든 정점의 최단거리를 max값으로 초기화.
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			// a에서 b로가는 가중치 distance;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			// 서로다른 두 정점 사이에 여러간선이 존재할 수있으므로 가장 짧은것으로 저장.
			if (adjsSet[a].contains(b)) {
				for (int[] adj : adjs[a]) {
					if (adj[0] == b) {
						adj[1] = Math.min(adj[1], distance);
						break;
					}
				}
			} else {
				adjs[a].add(new int[] { b, distance });
				adjsSet[a].add(b);
			}
		}

		// 방문한 정점 저장.
		Set<Integer> visit = new HashSet<>();

		// 방문하지 않은 정점들중 가장 가까운 정점 방문.
		PriorityQueue<int[]> unvisit = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		shortestpath[s] = 0; // 시작 정점부터 시작정점까지의 거리는 0으로 초기화.
		unvisit.add(new int[] { s, 0 });

		while (!unvisit.isEmpty()) {
			int[] deque = unvisit.poll();
			int num = deque[0];
			int distance = deque[1]; // 시작 정점에서 num 까지의 거리.

			if (visit.contains(num))
				continue;
			visit.add(num);

			for (int[] adj : adjs[num]) {
				int adjnum = adj[0];
				int adjDistance = adj[1]; // num과 직접 연결된 가중치.
				if (!visit.contains(adjnum) && shortestpath[num] != Integer.MAX_VALUE
						&& shortestpath[adjnum] > shortestpath[num] + adjDistance) {
					shortestpath[adjnum] = shortestpath[num] + adjDistance;
					// 업데이트 되었으니 저장.
					unvisit.add(new int[] { adj[0], shortestpath[adj[0]] });
				}

			}
		}
		for (int i = 1; i <= v; i++) {
			if (shortestpath[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(shortestpath[i]);
		}

	}

}
