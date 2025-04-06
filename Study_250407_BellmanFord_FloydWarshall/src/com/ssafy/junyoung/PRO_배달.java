package com.ssafy.junyoung;

import java.util.*;

class Solution {
    private final int INF = Integer.MAX_VALUE;
    private final int START = 0;
    private final int END = 1;
    private final int VALUE = 2;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        List<Edge>[] adj = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<road.length; i++) {
            adj[road[i][START]].add(new Edge(road[i][END], road[i][VALUE]));
            adj[road[i][END]].add(new Edge(road[i][START], road[i][VALUE]));
        }

        int start = 1;
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            for(Edge e : adj[edge.e]) {
                if(dist[e.e] > dist[edge.e] + e.cost) {
                    dist[e.e] = dist[edge.e] + e.cost;
                    pq.offer(e);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}

class Edge implements Comparable<Edge>{
    int e, cost;

    Edge(int e, int cost) {
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}
