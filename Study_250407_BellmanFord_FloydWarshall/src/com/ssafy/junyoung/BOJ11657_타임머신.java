package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class BOJ11657_타임머신 {
    static long[] dist;
    static boolean negativeCycle;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        dist = new long[N + 1];
        negativeCycle = false;
        Arrays.fill(dist, INF);
        dist[1] = 0;

        bellmanFord(N, 0, edges);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; ++i) {
            if (negativeCycle) {
                sb.append(-1).append("\n");
                break;
            }
            if (dist[i] == INF) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void bellmanFord(int n, int start, List<Edge> edges) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;

            for (Edge edge : edges) {
                if (dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.cost) {
                    dist[edge.e] = dist[edge.s] + edge.cost;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        // negative cycle
        for (Edge edge : edges) {
            if (dist[edge.s] != INF && dist[edge.s] + edge.cost < dist[edge.e]) {
                negativeCycle = true;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
