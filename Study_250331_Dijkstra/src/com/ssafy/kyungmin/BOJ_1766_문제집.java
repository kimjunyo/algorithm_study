package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 초기화
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N + 1];

		int A;
		int B;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
			inDegree[B]++;
		}

		// 확인
//		for (int i = 1; i <= N; i++) {
//			System.out.println(graph[i]);
//		}

		// 문제번호가 낮을 수록 가중치가 낮은 격이므로 pq통해서 적용하기 좋음
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				pq.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int start = pq.poll();

			sb.append(start).append(" ");

			for (Integer itg : graph[start]) {
				inDegree[itg]--;
				if (inDegree[itg] == 0) {
					pq.offer(itg);
				}
			}
		}

		System.out.println(sb.toString().trim());
	}

}
