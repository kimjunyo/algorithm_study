package com.ssafy.minji;

import java.util.*;

class Solution {
    static int[] set;
    
    public int solution(int n, int[][] costs) {
        set = new int[n];
        for(int i = 0 ; i < n ; i++){
            set[i] = i;
        }
                
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        for(int[] cost : costs){
            pq.add(cost);
        }
        
        int[] temp;
        int i1;
        int i2;
        int cost;
        int answer = 0;
        while(!pq.isEmpty()){
            temp = pq.poll();
            i1 = temp[0];
            i2 = temp[1];
            cost = temp[2];
            if(findSet(i1) != findSet(i2)){
                unionSet(i1, i2);
                answer += cost;
            }
        }
         
        return answer;
    }
    
    public int findSet(int i){
        if(set[i] == i){
            return i;
        }
        return set[i] = findSet(set[i]);
    }

    public void unionSet(int i, int j){
        i = findSet(i);
        j = findSet(j);
        if(i < j){
            set[j] = i;
        }else{
            set[i] = j;
        }
    }
}