package com.ssafy.junyoung.특정거리의도시찾기_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] nodes, distance;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        nodes = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            graph[a].add(b);
        }

        visited[X] = true;
        bfs(X);
        boolean isExist = false;

        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                isExist = true;
                System.out.println(i);
            }
        }

        if (!isExist) {
            System.out.println(-1);
        }
    }

    static void bfs(int X) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (distance[node] > K) {
                return;
            }

            if (graph[node] != null) {
                for (int i = 0; i < graph[node].size(); i++) {
                    if (!visited[graph[node].get(i)]) {
                        visited[graph[node].get(i)] = true;
                        distance[graph[node].get(i)] = distance[node] + 1;
                        q.offer(graph[node].get(i));
                    }
                }
            }
        }
    }
}
