package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= cases; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 건물의 갯수.(1번 부터~)
			int k = Integer.parseInt(st.nextToken()); // 규칙의 갯수.
			int[] buildTime = new int[n + 1]; // 각 건물의 건설 시간.
			int[] preBuildTime = new int[n + 1]; // 각 건물을 짓기 전까지 걸리는 시간.
			int[] indegree = new int[n + 1]; // 각 건물의 진입 차수.
			List<Integer>[] adjs = new ArrayList[n + 1]; // 각 건물의 다음으로 짓는 건물번호들.

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				adjs[i] = new ArrayList<Integer>();
				buildTime[i] = Integer.parseInt(st.nextToken());
			} // 건설시간 저장.

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int pre = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				adjs[pre].add(next);

				indegree[next]++; // 진입차수 증가.

			} // 인접건물저장

			// 특정건물.
			int target = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

			Queue<Integer> needtovisit = new ArrayDeque<>(); // 진입차수 0인 건물 저장.
			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0)
					needtovisit.add(i);
			}

			while (!needtovisit.isEmpty()) {
				int deque = needtovisit.poll();
				int time = preBuildTime[deque] + buildTime[deque];
				if (deque == target) {
					result.append(time).append("\n");
					break;
				}

				for (int adj : adjs[deque]) {
					if (preBuildTime[adj] < time)
						preBuildTime[adj] = time;

					indegree[adj]--;
					if (indegree[adj] == 0)
						needtovisit.add(adj);
				}
			}

		} // tc

		bw.write(result.toString().trim());
		bw.flush();

	}// main

}
