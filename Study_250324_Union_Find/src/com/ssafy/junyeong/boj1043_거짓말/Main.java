package com.ssafy.junyeong.boj1043_거짓말;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numTrue = Integer.parseInt(st.nextToken());

        int[] people = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            people[i] = i;
        }

        for (int i = 0; i < numTrue; i++) {
            people[Integer.parseInt(st.nextToken())] = 0;
        }

        List<int[]> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int[] party = new int[num];
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < num; j++) {
                party[j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, party[j]);
            }

            for (int j = 0; j < num; j++) {
                union(party[j], min, people);
            }

            parties.add(party);
        }

        int count = 0;

        for (int[] i : parties) {
            if (find(i[0], people) == 0) {
                continue;
            }
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
        System.out.println("123");
    }

    private static int find(int idx, int[] parent) {
        if (parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = find(parent[idx], parent);
    }

    private static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);

        if (x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
