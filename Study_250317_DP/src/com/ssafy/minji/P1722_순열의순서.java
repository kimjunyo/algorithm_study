package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1722_순열의순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        if(type == 1) {
            long k = Long.parseLong(st.nextToken());
            k--;
            
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                nums.add(i);
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = N; i >= 1; i--) {
                long idx = k / fact[i - 1];
                k %= fact[i - 1];
                int num = nums.get((int) idx);
                sb.append(num).append(" ");
                nums.remove((int) idx);
            }
            
            System.out.println(sb.toString().trim());
        } else if(type == 2) {
            int[] permutation = new int[N];
            for (int i = 0; i < N; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }
            
            boolean[] used = new boolean[N + 1];
            long rank = 0;
            
            for (int i = 0; i < N; i++) {
                int curr = permutation[i];
                int count = 0;
                for (int j = 1; j < curr; j++) {
                    if (!used[j]) {
                        count++;
                    }
                }
                rank += count * fact[N - i - 1];
                used[curr] = true;
            }
            System.out.println(rank + 1);
        }
    }
}

