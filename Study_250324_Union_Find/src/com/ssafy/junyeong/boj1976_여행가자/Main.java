package com.ssafy.junyeong.boj1976_여행가자;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] cities = new int[N+1];

        for (int i = 1; i <= N; i++) {
            cities[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if(st.nextToken().equals("1")) {
                    union(i, j, cities);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        if(set.size() == 0) {
            bw.write("NO");
            bw.flush();
            br.close();
            bw.close();
            return;
        }
        int start = 0;
        for(int i: set) {
            if(start == 0) {
                start = find(i, cities);
                continue;
            }
            if(start != find(i, cities)) {
                bw.write("NO");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
        }
        bw.write("YES");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);

        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
