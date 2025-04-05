package com.ssafy.minji;

import java.util.*;

class PRO_12978_배달 {
    public int solution(int N, int[][] road, int K) {
        final long INF = Long.MAX_VALUE;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        int from;
        int to;
        int cost;
        for(int i = 0 ; i < N - 1 ; i++){
            for(int[] edge : road){
                cost = edge[2];
                
                from = edge[0];
                to = edge[1];
                if(dist[from] != INF && dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                }
                
                from = edge[1];
                to = edge[0];
                if(dist[from] != INF && dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                }
            }
        }
        
        int cnt = 0;
        for(long i : dist){
            if(i <= K){
                cnt++;
            }
        }
        
        return cnt;
    }
}