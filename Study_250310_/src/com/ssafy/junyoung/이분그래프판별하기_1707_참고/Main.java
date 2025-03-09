package com.ssafy.junyoung.이분그래프판별하기_1707_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> graph[];
    static int N;
    static int[] check;
    static boolean isRound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            check = new int[N + 1];
            isRound = false;

            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int j = 1; j <= N; j++) {
                if(check[j] == 0 && isRound == false){
                    dfs(j, 1);
                }
            }
            if (isRound) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void dfs(int index, int value) {
        check[index] = value;
        for (int i : graph[index]) {
            if (check[i] == 0) {
                check[i] = 3 - check[index];
                dfs(i, check[i]);
            } else if (check[i] == check[index]) {
                isRound = true;
                return;
            }
        }
    }
}
