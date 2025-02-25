package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        int cnt1 = 0, cnt0 = 0;
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(); 
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == 0) {
                cnt0++;
            } else if (arr[i] == 1) {
                cnt1++;
            } else if (arr[i] < 0) {
                minusQ.add(arr[i]); 
            } else {
                plusQ.add(arr[i]); 
            }
        }

        int result = 0;

        while (minusQ.size() >= 2) {
            result += minusQ.poll() * minusQ.poll(); 
        }

        if (minusQ.size() == 1) {
            result += minusQ.poll(); 
        }

        while (plusQ.size() >= 2) {
            result += plusQ.poll() * plusQ.poll(); 
        }

        if (plusQ.size() == 1) {
            result += plusQ.poll(); 
        }

        result += cnt1;


        System.out.println(result);
    }
}
