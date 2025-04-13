package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class GR_195699_통신망분석 {
	static int N; // ~100000
	static int[] parent;
	static List<Integer>[] graph;
	static Map<Integer, Integer> edgeCounts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		// 1~200000
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		edgeCounts = new HashMap<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);

			graph[a].add(b);
			graph[b].add(a);

			int aCnt = edgeCounts.getOrDefault(a, 0);
			int bCnt = edgeCounts.getOrDefault(b, 0);
			edgeCounts.put(a, aCnt + 1);
			edgeCounts.put(b, bCnt + 1);
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			int rootI = find(i);

			List<Integer> list = map.getOrDefault(rootI, new ArrayList<>());
			list.add(i);
			map.put(rootI, list);
		}

		List<Map.Entry<Integer, List<Integer>>> rootNodeList = new ArrayList<>(map.entrySet());
		rootNodeList.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

		double max = Integer.MIN_VALUE;
		int rootMax = 0;
		for (Integer rootA : map.keySet()) {
			int nodes = map.get(rootA).size();
			// 풀다가 지쳐서 여기까지..
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : map.get(rootMax)) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		parent[rootA] = rootB;

	}

	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}

}