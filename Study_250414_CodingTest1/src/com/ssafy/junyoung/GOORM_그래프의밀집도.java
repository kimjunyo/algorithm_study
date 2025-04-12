package com.ssafy.junyoung;

import java.io.*;
import java.util.*;
public class GOORM_그래프의밀집도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] parent = new int[N+1];
        int[] component = new int[N+1];
        int[] line = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, parent);
            if(a < b) {
                line[a]++;
            } else {
                line[b]++;
            }
        }

        for(int i=1; i<=N; i++) {
            int value = find(i, parent);
            component[value]++;
            if(value != i) line[value] += line[i];
        }

        double maxMildo = -1;
        List<Integer> maxList = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(component[i] != 0) {
                if(maxMildo < line[i] * 1.0 / component[i]) {
                    maxMildo = line[i] * 1.0 / component[i];
                    maxList = new ArrayList<>();
                    maxList.add(i);
                } else if (maxMildo == line[i] * 1.0 / component[i]) {
                    maxList.add(i);
                }
            }
        }

        List<Integer> minList = new ArrayList<>();
        if(maxList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=N; i++) {
                if(parent[i] == maxList.get(0)) {
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb.toString());
            return;
        } else {
            int minComputer = Integer.MAX_VALUE;
            for(int i : maxList) {
                if(component[i] < minComputer) {
                    minComputer = component[i];
                    minList = new ArrayList<>();
                    minList.add(i);
                } else if(component[i] == minComputer) {
                    minList.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(parent[i] == minList.get(0)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());

    }

    private static int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        else
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