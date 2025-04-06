package com.ssafy.junyoung;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11404_플로이드 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] arr = new long[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }


        for (int j = 1; j <= M; ++j) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Long.min(c, arr[a][b]);
        }

        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    arr[i][j] = Long.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if(arr[i][j]==INF) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
