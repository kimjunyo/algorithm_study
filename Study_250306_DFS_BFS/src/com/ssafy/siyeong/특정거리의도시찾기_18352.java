package com.ssafy.siyeong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 특정거리의도시찾기_18352 {
    static List<Integer>[] adjList;
    static int[] distance;
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : adjList[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        
        adjList = new ArrayList[N + 1];
        distance = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            distance[i] = -1; 
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
        }
        
        bfs(X); 
        
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println(-1);
        }
    }
}
