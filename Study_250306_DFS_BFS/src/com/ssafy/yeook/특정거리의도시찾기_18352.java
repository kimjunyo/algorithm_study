package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_18352 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 도시갯수
		int m = Integer.parseInt(st.nextToken());// 엣지갯수
		int d = Integer.parseInt(st.nextToken());// 거리
		int s = Integer.parseInt(st.nextToken()); // 출발도시번호
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new Node());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.get(from).adj.add(to);
		}

		Queue<Integer> needtovisit = new LinkedList<>();
		needtovisit.add(s);
		map.get(s).distance = 0;
		LinkedList<Integer> result = new LinkedList<>();

		while (!needtovisit.isEmpty()) {
			int deque = needtovisit.poll();
			int curd = map.get(deque).distance;
			if (curd < d) {
				for (int adj : map.get(deque).adj) {
					if (map.get(adj).distance == -1) {
						map.get(adj).distance = curd + 1;
						if (map.get(adj).distance == d) {
							result.add(adj);
						} else {
							needtovisit.add(adj);
						}
					}
				}
			}
		} // d인 거리 도시번호 저장.

		if (result.size() == 0) {
			System.out.println(-1);
			return;
		}
		int[] arr = result.stream().sorted().mapToInt(Integer::valueOf).toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	static class Node {
		int distance = -1;
		LinkedList<Integer> adj = new LinkedList<>();
	}

}
