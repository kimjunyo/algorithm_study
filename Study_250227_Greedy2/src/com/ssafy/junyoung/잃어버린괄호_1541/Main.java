package com.ssafy.junyoung.잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cal = br.readLine().toCharArray();

        int sum = 0;
        int num = 0;
        int minusCount = 0;

        for (char c : cal) {
            if (minusCount == 0) {
                if (c == '+') {
                    sum += num;
                    num = 0;
                    continue;
                }
                if (c == '-') {
                    sum += num;
                    num = 0;
                    minusCount++;
                    continue;
                }
            } else {
                if (c == '+' || c == '-') {
                    sum -= num;
                    num = 0;
                    continue;
                }
            }
            num = c - '0' + num * 10;
        }
        if (minusCount == 0) {
            sum += num;
        } else {
            sum -= num;
        }

        System.out.println(sum);

    }
}
