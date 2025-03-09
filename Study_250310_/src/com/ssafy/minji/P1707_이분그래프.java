package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine().trim());

		nextCase: for (int tc = 1; tc <= K; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			List<Integer>[] nodes = new ArrayList[V + 1];
			for (int i = 0; i < V + 1; i++) {
				nodes[i] = new ArrayList<Integer>();
			}
			int v1;
			int v2;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				v1 = Integer.parseInt(st.nextToken());
				v2 = Integer.parseInt(st.nextToken());
				nodes[v1].add(v2);
				nodes[v2].add(v1);
			}

			Map<Integer, Integer> group = new HashMap<>();
			Queue<Integer> que = new LinkedList<Integer>();
			for (int i = 1; i < V; i++) {
				if (!group.containsKey(i)) {
					que.add(i);
					group.put(i, 1);
				}
				while (!que.isEmpty()) {
					int temp = que.poll();
					for (int node : nodes[temp]) {
						if (!group.containsKey(node)) {
							group.put(node, -group.get(temp));
							que.add(node);

						} else if (group.get(node) == group.get(temp)) {
							System.out.println("NO");
							continue nextCase;
						}
					}
				}
			}
			System.out.println("YES");
		}
	}
}
