package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class GRM_주차시스템{
    static int[][] parkingArea;
    static int N, M, max;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parkingArea = new int[N][M];
        visited = new boolean[N][M];
        max = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                parkingArea[i][j] = Integer.parseInt(st.nextToken());
                if(parkingArea[i][j] == 1) visited[i][j] = true;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) bfs(i, j);
            }
        }
        bw.write(max+"");
        bw.flush();
    }

    private static void bfs(int i, int j) {
        int score = cal(parkingArea[i][j]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int k=0; k<n; k++) {
                int[] input = queue.poll();

                for(int m=0; m<4; m++) {
                    int nr = input[0] + dr[m];
                    int nc = input[1] + dc[m];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    score+=cal(parkingArea[nr][nc]);

                }
            }
        }
        max = Integer.max(max, score);
    }

    private static int cal(int area) {
        if(area == 2) {
            return -2;
        } else if (area == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}