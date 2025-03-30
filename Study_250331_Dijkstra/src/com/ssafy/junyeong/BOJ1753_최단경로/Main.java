package com.ssafy.junyeong.BOJ1753_최단경로;

import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Edge>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {
        int index, value;

        Edge(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, c));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int currIdx = pq.poll().index;
            if (visited[currIdx]) continue;

            visited[currIdx] = true;
            for (Edge edge : adj[currIdx]) {
                if (!visited[edge.index] && dist[edge.index] > dist[currIdx] + edge.value) {
                    dist[edge.index] = dist[currIdx] + edge.value;
                    pq.offer(new Edge(edge.index, dist[edge.index]));
                }
            }
        }
    }
}
