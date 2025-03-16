package jungol.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class JOL_1205_조커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>(); 
        PriorityQueue<Integer> q = new PriorityQueue<>(); 
        int cntZero = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) cntZero++; 
            else set.add(num);
        }

        q.addAll(set); 

        if (q.isEmpty()) { 
            System.out.println(cntZero);
            return;
        }

        int maxLen = 0, cnt =1;
        int prev = q.poll(); 
        int availableZero = cntZero; 

        while (!q.isEmpty()) {
            int curr = q.poll();
            int gap = curr - prev;

            if (gap == 1) { 
                cnt++;
            } else { 
                if (availableZero >= gap-1) {
                    availableZero -= (gap-1);
                    cnt += gap;
                } else {
                    maxLen = Math.max(maxLen, cnt + availableZero);
                    cnt = 1; 
                    availableZero = cntZero;
                }
            }
            prev = curr; 
        }
        maxLen = Math.max(maxLen, cnt + availableZero);
        System.out.println(maxLen);
    }
}