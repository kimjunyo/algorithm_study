package com.als.yeook;

import java.util.*;
import java.io.*;

public class 구간합구하기5_S11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n][n];

        //0,0부터 x,y까지의 사각형의 합.
        //sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+num;
        for (int i = 0; i < n; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(nums.nextToken());
                if (i == 0) {
                    if (j == 0) {
                        sum[i][j] = num;
                    } else {
                        sum[i][j] = sum[i][j - 1] + num;
                    }
                } else {
                    if (j == 0) {
                        sum[i][j] = sum[i - 1][j] + num;
                    } else {
                        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer indexes = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(indexes.nextToken()) - 1;
            int startY = Integer.parseInt(indexes.nextToken()) - 1;
            int endX = Integer.parseInt(indexes.nextToken()) - 1;
            int endY = Integer.parseInt(indexes.nextToken()) - 1;
            if (startX == 0) {
                if (startY == 0) {
                    result.append(sum[endX][endY]).append("\n");
                } else {
                    result.append(sum[endX][endY] - sum[endX][startY - 1]).append("\n");
                }
            } else {
                if (startY == 0) {
                    result.append(sum[endX][endY] - sum[startX - 1][endY]).append("\n");
                } else {
                    result.append(sum[endX][endY] - sum[startX - 1][endY] - sum[endX][startY - 1] + sum[startX - 1][startY - 1]).append("\n");
                }
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
