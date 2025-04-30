package com.ssafy.sjihyun
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] subtree;
    static boolean[] visit;

    public static int findSubTree(int node) {
    	visit[node] = true;
    	subtree[node] = 1;
    	for(int n : graph[node]) {
    		if(!visit[n]) {
    			subtree[node] += findSubTree(n);
    		}
    	}
    	return subtree[node];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        subtree = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        findSubTree(R);

        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(subtree[node]).append("\n");
        }
        System.out.print(sb);
    }
}
