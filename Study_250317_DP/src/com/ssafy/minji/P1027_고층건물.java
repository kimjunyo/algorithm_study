package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1027_고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSight = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            
            double maxSlope = -Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(height[j] - height[i]) / (i - j);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }
            
            maxSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(height[j] - height[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }
            maxSight = Math.max(maxSight, count);
        }
        
        System.out.println(maxSight);
    }
}

