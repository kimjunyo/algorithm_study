package com.ssafy.junyoung.카드정렬하기_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int before;
        int sum = 0;

        while (pq.size() > 1) {
            before = pq.poll() + pq.poll();
            sum += before;
            pq.offer(before);
        }
        System.out.println(sum);

        // 10 20 : 30
        // 30 30 : 60
        // 60 40  : 100
    }
}
