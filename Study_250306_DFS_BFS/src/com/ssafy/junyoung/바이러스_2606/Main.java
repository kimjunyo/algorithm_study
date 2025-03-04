package com.ssafy.junyoung.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (arr[a] == null) {
                arr[a] = new ArrayList<>();
            }
            if (arr[b] == null) {
                arr[b] = new ArrayList<>();
            }
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);
        System.out.println(count);
    }

    static void bfs(int cur) {
        visited[cur] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (arr[n] != null) {
                for (int i = 0; i < arr[n].size(); i++) {
                    if (!visited[arr[n].get(i)]) {
                        visited[arr[n].get(i)] = true;
                        q.add(arr[n].get(i));
                    }
                }
            }
            count++;
        }
    }
}
