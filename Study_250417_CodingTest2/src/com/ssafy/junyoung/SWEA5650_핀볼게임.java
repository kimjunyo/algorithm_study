package com.ssafy.junyoung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5650_핀볼게임 {
    static int N, max;
    static int[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<int[]>[] warmHall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            max = Integer.MIN_VALUE;

            board = new int[N][N];
            warmHall = new ArrayList[11];

            for (int i = 6; i < 11; i++) {
                warmHall[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] >= 6) {
                        warmHall[board[i][j]].add(new int[]{i, j});
                    }
                }
            }

            // 1. 핀볼 시작점
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        // 2. 핀볼 굴리기
                        game(i, j);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void game(int startRow, int startCol) {

        // 3. 상하좌우로 굴리기
        for (int i = 0; i < 4; i++) {
            int count = 0;

            int direction = i;

            int row = startRow + dr[direction];
            int col = startCol + dc[direction];

            while (row != startRow || col != startCol) {
                if(row < 0 || row >= N || col < 0 || col >= N) {
                    direction = (direction + 2) % 4; // 반대 방향
                    count++;
                } else if (board[row][col] == -1) { // 블랙홀
                    break;
                } else if (board[row][col] >= 6) { // 웜홀
                    for(int k=0; k<2; k++) {
                        int[] hall = warmHall[board[row][col]].get(k);
                        if(row != hall[0] || hall[1]  != col) {
                            row = hall[0] ;
                            col = hall[1] ;
                            break;
                        }
                    }
                } else {
                    switch (board[row][col]) {
                        case 1:
                            switch(direction) {
                                case 2:
                                    direction = 1;
                                    break;
                                case 3:
                                    direction = 0;
                                    break;
                                case 1: case 0:
                                    direction = (direction + 2) % 4; // 반대 방향
                                    break;
                            }
                            count++;
                            break;
                        case 2:
                            switch(direction) {
                                case 0:
                                    direction = 1;
                                    break;
                                case 3:
                                    direction = 2;
                                    break;
                                case 1: case 2:
                                    direction = (direction + 2) % 4; // 반대 방향
                                    break;
                            }
                            count++;
                            break;
                        case 3:
                            switch(direction) {
                                case 0:
                                    direction = 3;
                                    break;
                                case 1:
                                    direction = 2;
                                    break;
                                case 2: case 3:
                                    direction = (direction + 2) % 4; // 반대 방향
                                    break;
                            }
                            count++;
                            break;
                        case 4:
                            switch(direction) {
                                case 2:
                                    direction = 3;
                                    break;
                                case 1:
                                    direction = 0;
                                    break;
                                case 0: case 3:
                                    direction = (direction + 2) % 4; // 반대 방향
                                    break;
                            }
                            count++;
                            break;
                        case 5:
                            direction = (direction + 2) % 4; // 반대 방향
                            count++;
                            break;
                    }
                }

                row = row + dr[direction];
                col = col + dc[direction];

            }

            max = Math.max(max, count);
        }
    }
}
