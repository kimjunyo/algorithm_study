package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class GRM_불이야 {
    static char[][] arr;
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int startR = -1;
        int startJ = -1;

        arr = new char[R][C];
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = input.charAt(j);
                if(arr[i][j] == '&') {
                    startR = i;
                    startJ = j;
                }
            }
        }

        bw.write(bfs(startR, startJ)+"");
        bw.flush();
    }

    private static int bfs(int i, int j) {
        boolean[][] visited = new boolean[R][C];
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        int count = 0;
        boolean isFire = false;

        while(!queue.isEmpty() && !isFire) {
            int n = queue.size();

            for(int k=0; k<n; k++) {
                int[] input = queue.poll();

                for(int m=0; m<4; m++) {
                    int nr = input[0] + dr[m];
                    int nc = input[1] + dc[m];

                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || arr[nr][nc] == '#') continue;

                    if(arr[nr][nc] == '@') isFire = true;
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            count++;
        }
        if(!isFire) return -1;
        return count - 1;
    }
}