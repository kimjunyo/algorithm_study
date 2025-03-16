package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    
    static List<Integer>[] counsel; 
    static int result = Integer.MIN_VALUE;
    
    private static void findCombination(int day, int sum) {
        if (day >= counsel.length) { 
            result = Math.max(result, sum);
            return;
        }

        if (day + counsel[day].get(0) <= counsel.length) { 
            findCombination(day + counsel[day].get(0), sum + counsel[day].get(1));
        }

        findCombination(day + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        counsel = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            counsel[i] = new ArrayList<>();
            counsel[i].add(Integer.parseInt(st.nextToken()));
            counsel[i].add(Integer.parseInt(st.nextToken()));
        }
        findCombination(0, 0);
        System.out.println(result);
    }
}
