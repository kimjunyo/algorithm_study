package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123_더하기 {
    static int N, cnt;
    static int[] arr = {1,2,3};

    private static void permutation(int sum) {
        if (sum > N) return; 
        if (sum == N) { 
            cnt++;
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            permutation(sum + arr[i]); 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            permutation(0); 
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
