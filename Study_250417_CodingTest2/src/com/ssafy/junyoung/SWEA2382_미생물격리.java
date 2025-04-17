package com.ssafy.junyoung;

import java.io.*;
import java.util.*;

public class SWEA2382_미생물격리 {
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    static int N, M, K;
    static List<Gyun> gyuns;

    static class Gyun implements Comparable<Gyun>{
        @Override
        public int compareTo(Gyun o) {
            if(this.row == o.row) {
                if(this.col == o.col) {
                    return o.number - this.number;
                }
                return this.col - o.col;
            }
            return this.row - o.row;
        }

        int row, col, number, dir;

        Gyun(int row, int col, int number, int dir) {
            this.row = row;
            this.col = col;
            this.number = number;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb= new StringBuilder();

        int TC = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            gyuns = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                gyuns.add(new Gyun(row, col, number, dir));
            }

            for (int i = 0; i < M; i++) {
                for (Gyun gyun : gyuns) {
                    int nextRow = gyun.row + dr[gyun.dir];
                    int nextCol = gyun.col + dc[gyun.dir];

                    gyun.row = nextRow;
                    gyun.col = nextCol;
                    if (nextRow == 0 || nextRow == N - 1 || nextCol == 0 || nextCol == N - 1) {
                        gyun.number = gyun.number / 2;
                        if (gyun.dir == 1 || gyun.dir == 2) {
                            gyun.dir = 3 - gyun.dir;
                        } else {
                            gyun.dir = 7 - gyun.dir;
                        }
                    }
                }

                Collections.sort(gyuns);

                List<Gyun> gyunCopy = new ArrayList<>(gyuns);
                Gyun beforeGyun = null;
                for(Gyun gyun : gyunCopy) {
                    if(Objects.nonNull(beforeGyun) && gyun.row == beforeGyun.row && gyun.col == beforeGyun.col) {
                        beforeGyun.number += gyun.number;
                        gyuns.remove(gyun);
                    } else {
                        if(beforeGyun != null) {
                            gyuns.add(beforeGyun);
                        }
                        beforeGyun = gyun;
                        gyuns.remove(gyun);
                    }
                }
                if(beforeGyun != null) {
                    gyuns.add(beforeGyun);
                }
                
            }

            int sum = 0;
            for (Gyun gyun : gyuns) {
                sum += gyun.number;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
