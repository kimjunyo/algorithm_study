package com.ssafy.junyoung.최대공약수_1850;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N1 = Long.parseLong(st.nextToken());
        long N2 = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if(N1 < N2) {
            long temp = N1;
            N1 = N2;
            N2 = temp;
        }

        while(N2 > 0) {
            long temp = N2;
            N2 = N1 % N2;
            N1 = temp;
        }

        while(N1-- > 0) {
            sb.append("1");
        }

        System.out.println(sb);
    }


}