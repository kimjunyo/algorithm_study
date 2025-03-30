package com.ssafy.junyeong.BOJ1916_최소비용구하기;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static int[] dist;
    static List<Edge>[] adj;

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

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adj = new List[V+1];
        dist = new int[V+1];

        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 1; i <= E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(String.valueOf(dist[end]));
        bw.flush();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int currIdx = pq.poll().index;

            if(visited[currIdx]) continue;

            visited[currIdx] = true;

            for (Edge e : adj[currIdx]) {
                if(!visited[e.index] && dist[currIdx] + e.value < dist[e.index]) {
                    dist[e.index] = dist[currIdx] + e.value;
                    pq.add(new Edge(e.index, dist[e.index]));
                }
            }
        }
    }
}
