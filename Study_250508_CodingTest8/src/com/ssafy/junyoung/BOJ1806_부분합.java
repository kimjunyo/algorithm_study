package com.ssafy.junyoung;

import java.util.*;
import java.io.*;

public class BOJ1806_부분합 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        bw.write((min == Integer.MAX_VALUE ? 0 : min) + "\n");
        bw.flush();
    }
}
