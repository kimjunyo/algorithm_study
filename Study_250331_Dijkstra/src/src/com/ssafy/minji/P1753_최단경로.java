package src.com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int to;
	int cost;

	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class P1753_최단경로 {

	static List<Edge>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine().trim());

		edges = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		int u;
		int v;
		int w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v, w));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		pq.add(new Edge(K, 0));

		Edge e;
		while (!pq.isEmpty()) {
			e = pq.poll();

			if (dist[e.to] < e.cost) {
				continue;
			}
			
			for (Edge next : edges[e.to]) {
				if (dist[next.to] > dist[e.to] + next.cost) {
					dist[next.to] = dist[e.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < V + 1; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}
