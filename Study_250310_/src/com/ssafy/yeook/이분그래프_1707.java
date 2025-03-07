package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		int cases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= cases; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());// 정점의 갯수
			int e = Integer.parseInt(st.nextToken());// 간선의 갯수

			Set<Integer> nonvisit = new HashSet<>(); // 팀이 안정해진 정점들 저장.
			Node[] nodes = new Node[v + 1]; // 배열에 Node객체 저장.

			for (int i = 1; i <= v; i++) {
				nodes[i] = new Node();
				nonvisit.add(i);
			}

			// 주어진 간선으로 인접 정점들 저장.
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodes[a].adj.add(b);
				nodes[b].adj.add(a);
			}

			boolean isOk = true; // 이분그래프인지 판별
			outer: for (int i = 1; i <= v; i++) { // 탐색안한 정점만 순회.
				if (!nonvisit.contains(i)) {
					continue;
				}
				Queue<Integer> needtovisit = new LinkedList<>();
				boolean[] visit = new boolean[v + 1]; // 배열로 방문여부 체크.
				needtovisit.add(i);
				visit[i] = true;
				nonvisit.remove(i);
				nodes[i].team = 1;

				while (!needtovisit.isEmpty()) {
					int deque = needtovisit.poll();
					int team = nodes[deque].team;// 팀을 정함
					nonvisit.remove(deque);
					for (int j : nodes[deque].adj) {
						int curteam = nodes[j].team;
						if (curteam == team) { // 인접 정점끼리 팀이 같으면 이분그래프 아님.
							isOk = false;
							break outer;
						}
						if (curteam == 0) { // 인접정점과 다른 팀으로 설정하기.
							if (team == 1) {
								nodes[j].team = 2;
							} else {
								nodes[j].team = 1;
							}
						}
						if (!visit[j]) { // bfs순회하기.
							visit[j] = true;
							needtovisit.add(j);
						}

					}
				}
			}
			if (isOk) {
				result.append("YES").append("\n");
			} else {
				result.append("NO").append("\n");
			}

		} // tc
		bw.write(result.toString().trim());
		bw.flush();

	}

	static class Node {
		int team; // 두 팀으로 나뉘어 지는지 판단. 1또는 2 저장.
		List<Integer> adj = new ArrayList<>(); // 인접정점 저장.
	}

}
