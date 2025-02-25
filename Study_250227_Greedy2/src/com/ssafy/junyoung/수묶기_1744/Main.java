package com.ssafy.junyoung.수묶기_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minusCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) minusCount++;
            pq.offer(num);
        }

        int sum = 0;

        // 양수의 갯수: 짝수, 홀수

        // 0

        // 1

        // 음수의 갯수: 짝수, 홀수

        while (!pq.isEmpty() && pq.peek() > 0) {
            int i = pq.poll();

            // 비었을 때 더해주고 끝.
            if (pq.isEmpty()) {
                sum += i;
                break;
            }

            // 첫번째가 1인 경우
            if (i == 1) {
                sum += 1;
                continue;
            }

            if (pq.peek() <= 0) {
                sum += i;
                break;
            }

            int j = pq.poll();

            // 두번째가 1인 경우
            if (j == 1) {
                sum += i + j;
                continue;
            }
            sum += i * j;
        }

        // 0이거나, 음수인 경우
        while (!pq.isEmpty()) {
            if (pq.peek() == 0) {
                pq.poll();
                if (minusCount % 2 != 0) {
                    if (pq.isEmpty()) break;
                    pq.poll();
                    minusCount--;
                }
            } else {
                if (minusCount % 2 == 0) {
                    int num1 = pq.poll();
                    int num2 = pq.poll();
                    sum += num1 * num2;
                } else {
                    sum += pq.poll();
                    minusCount--;
                }
            }


        }

        System.out.println(sum);
    }
}
