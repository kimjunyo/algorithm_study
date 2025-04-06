package com.ssafy.junyoung;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = Y * 100 / X;

        double ans = (Z * X + X - 100 * Y) * 1.0 / (99 - Z);

        if (Math.ceil(ans) <= 0 || (int) Math.ceil(ans) == Integer.MAX_VALUE)
            bw.write("-1");
        else bw.write((int) Math.ceil(ans) + "");
        bw.flush();
    }
}