package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] trash = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    trash[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i=0; i<N-K+1; i++) {
                for(int j=0; j<N-K+1; j++) {
                    int sum = 0;

                    for(int k1 = i; k1<i+K; k1++) {
                        for(int k2 = j; k2<j+K; k2++) {
                            sum+=trash[k1][k2];
                        }
                    }
                    min = Integer.min(sum, min);
                }
            }

            System.out.println(min);
        }

    }
}