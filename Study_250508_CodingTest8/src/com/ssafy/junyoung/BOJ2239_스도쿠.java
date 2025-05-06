package com.ssafy.junyoung;
import java.io.*;
import java.util.*;

public class BOJ2239_스도쿠 {
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][] smallBoards = new boolean[9][10];
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
                rows[i][board[i][j]] = true;
                cols[j][board[i][j]] = true;
                smallBoards[3*(i/3) + (j/3)][board[i][j]] = true;
            }
        }
        sudoku(0);
    }


    static void sudoku(int idx) {
        if (idx >= 81) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]+"");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        int r = idx / 9, c = idx % 9;

        if (board[r][c] != 0) sudoku(idx+1);

        else {
            for (int i = 1; i < 10; i++) {
                if (rows[r][i] || cols[c][i] || smallBoards[3*(r/3)+c/3][i]) continue;
                rows[r][i] = true;
                cols[c][i] = true;
                smallBoards[3*(r/3)+c/3][i] = true;
                board[r][c] = i;
                sudoku(idx+1);
                rows[r][i] = false;
                cols[c][i] = false;
                smallBoards[3*(r/3)+c/3][i] = false;
                board[r][c] = 0;
            }
        }
    }
}
