package com.ssafy.junyoung.이항계수2_11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][K+1];

        System.out.println(f(N, K));
    }

    private static int f(int N, int K) {
        if(K == 0) return 1;
        else if(N == 1) return 1;
        else if(N == K) return 1;
        if (arr[N][K] != 0) return arr[N][K];

        return arr[N][K] = (f(N-1, K) + f(N-1, K-1)) % 10_007;
    }
}
