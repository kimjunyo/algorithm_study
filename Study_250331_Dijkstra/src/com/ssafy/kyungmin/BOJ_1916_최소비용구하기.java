package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	static class Node {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도 개수 1~1000
		int N = Integer.parseInt(br.readLine());
		// 간선 개수 1~300000
		int M = Integer.parseInt(br.readLine());

		// 초기화
		List<Node>[] graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] distances = new int[N + 1];
		Arrays.fill(distances, INF);

		int A;
		int B;
		int W; // 0~100000
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph[A].add(new Node(B, W));
		}

		// 확인
//		for (int i = 1; i <= N; i++) {
//			System.out.println(graph[i]);
//		}

		st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken());
		int arrival = Integer.parseInt(st.nextToken());

		// 다익스트라 시작
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

		distances[departure] = 0;
		pq.offer(new Node(departure, 0));

		while (!pq.isEmpty()) {
			Node nodeStart = pq.poll();

			if (nodeStart.to == arrival)
				break;

			if (distances[nodeStart.to] < nodeStart.cost)
				continue;

			for (Node nodeNext : graph[nodeStart.to]) {
				int dist = nodeStart.cost + nodeNext.cost;

				if (distances[nodeNext.to] > dist) {
					distances[nodeNext.to] = dist;
					// edgeB와 방향 정점은 같지만 가중치는 누적임
					pq.offer(new Node(nodeNext.to, dist));
				}
			}
		}

		System.out.println(distances[arrival]);
	}

}
