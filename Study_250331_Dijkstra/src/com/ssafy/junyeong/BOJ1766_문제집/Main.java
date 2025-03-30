package com.ssafy.junyeong.BOJ1766_문제집;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adj;
    static int[] position;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        position = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            position[b]++;
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=1; i<=N; i++) {
            if (position[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int n = pq.poll();

            sb.append(n).append(" ");

            for(int v : adj[n]) {
                position[v]--;
                if (position[v] == 0) {
                    pq.offer(v);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
}
