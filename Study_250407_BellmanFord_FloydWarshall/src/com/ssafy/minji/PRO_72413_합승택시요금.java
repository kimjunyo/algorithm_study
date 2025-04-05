package com.ssafy.minji;

import java.util.*;

// 플로이드워셜로 하니까 효율성 몇개는 결국 나가리
class PRO_72413_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 400_000;
        
        int dist[][] = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        int n1;
        int n2;
        int cost;
        for(int[] fare : fares){
            n1 = fare[0];
            n2 = fare[1];
            cost = fare[2];
            if(dist[n1][n2] > cost){
                dist[n1][n2] = dist[n2][n1] = cost;
            }
        }
        
		for (int k = 1; k <= n; k++) {
	        for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int ans = dist[s][a] + dist[s][b];
        for(int k = 1 ; k <= n ; k++){
            if(ans > dist[s][k] + dist[k][a] + dist[k][b]){
                ans = dist[s][k] + dist[k][a] + dist[k][b];
            }
        }
        return ans;
    }
}