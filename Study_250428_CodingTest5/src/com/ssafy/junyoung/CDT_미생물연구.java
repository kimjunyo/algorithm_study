package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class CDT_미생물연구 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for(int tc=0; tc<Q; tc++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            int gyun = 1;

            // 1. 미생물 투입
            for(int i = startR; i <= endR; i++) {
                for(int j = startC; j <= endC; j++) {
                    arr[i][j] = gyun;
                }
            }

            // 영역 구분

            // 2. 배양 용기 이동

            // 3. 실험 결과 기록
            gyun++;
        }




    }
}