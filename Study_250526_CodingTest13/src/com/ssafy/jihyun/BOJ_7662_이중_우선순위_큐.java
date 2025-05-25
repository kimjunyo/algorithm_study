package com.ssafy.jihyun;

import java.io.*;
import java.util.*;

public class BOJ_7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                char oper = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (oper == 'I') map.put(num, map.getOrDefault(num, 0) + 1);
                else if (oper == 'D') {
                    if (map.isEmpty()) continue;

                    if (num == 1) { 
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else { 
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
