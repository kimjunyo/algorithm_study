package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_1717_집합의_표현 {
    static int[] node;

    private static int findNode(int num) {
        if (node[num] == num) return num;
        return node[num] = findNode(node[num]);  
    }

    private static void union(int a, int b) {
        int rootA = findNode(a);
        int rootB = findNode(b);
        if (rootA != rootB) {
            if (rootA < rootB) node[rootB] = rootA;
            else node[rootA] = rootB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        node = new int[n + 1];
        Arrays.setAll(node, i -> i);  

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (caseNum == 0) {
                union(num1, num2);  
            } else {
                if (findNode(num1) == findNode(num2)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
