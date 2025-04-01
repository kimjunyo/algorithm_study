package com.ssafy.junyoung;

import java.util.PriorityQueue;

class Solution {
    final int FIRST = 0;
    final int SECOND = 1; 
    final int VALUE = 2;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[VALUE] - o2[VALUE]);
        
        int[] parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++) {
            pq.offer(costs[i]);
        }
        
        int pick = 0;
        while(!pq.isEmpty()) {
            int[] input = pq.poll();
            
            if(find(input[FIRST], parent) != find(input[SECOND], parent)) {
                union(input[FIRST], input[SECOND], parent);
                pick++;
                answer+=input[VALUE];
            }
            
            if(pick == n-1) break;
        }
        
        return answer;
    }
    
    private void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);
        
        if(x>y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
    
    private int find(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
}