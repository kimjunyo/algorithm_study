package com.ssafy.junyoung.물의양구하기_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


// 진짜 이건 풀 수가 없다..
public class Main {
    static int A, B, C;
    static Set<Integer> cSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cSet.add(C);

        if(A < B && B < C) {
            cSet.add(A);
            cSet.add(B);
            cSet.add(C-A);
            cSet.add(C-B);
        } else if (A > B && A < C) {
            cSet.add(A);
            cSet.add(B);
            cSet.add(C-B);
        } else if (A < C && B > C) {
            cSet.add(0);
            cSet.add(A);
            cSet.add(C-A);
        } else if (A > C && B < C) {
            cSet.add(B);
            cSet.add(C-B);
        } else if (A==B && B < C) {
            cSet.add(A);
            cSet.add(C-B);
        } else if (A==C && B < C) {
            cSet.add(B);
            cSet.add(C-B);
        } else if (B==C && A < C) {
            cSet.add(0);
            cSet.add(C-A);
            cSet.add(A);
        }
        else {
            cSet.add(0);
        }
        for (int i : cSet) {
            System.out.print(i + " ");
        }
    }
}
