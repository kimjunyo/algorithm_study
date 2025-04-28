package com.ssafy.junyoung;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[100_002];

        Arrays.fill(arr,-1);
        int second = -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        while (!q.isEmpty() && arr[K] == -1) {
            second++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int cur = q.poll();
                while(cur <= 100_000) {
                    if(arr[cur] != -1) break;
                    arr[cur] = second;
                    if(cur-1 >= 0 && arr[cur-1] == -1) q.offer(cur-1);
                    if(arr[cur+1] == -1) q.offer(cur+1);

                    cur *= 2;
                }
            }
        }

        bw.write(arr[K]+"");
        bw.flush();
    }
}