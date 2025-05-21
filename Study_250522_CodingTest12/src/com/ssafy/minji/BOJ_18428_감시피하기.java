package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
    static int N;
    static String[][] map;
    static List<int[]> teachers = new ArrayList();
    static List<int[]> empties = new ArrayList();
    static boolean found = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    teachers.add(new int[] { i, j });
                } else if (map[i][j].equals("X")) {
                    empties.add(new int[] { i, j });
                }
            }
        }

        dfs(0, 0);

        if(found) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static void dfs(int count, int start) {
        if (found) return;

        if (count == 3) {
            if (isSafe()) {
                found = true;
            }
            return;
        }

        for (int i = start; i < empties.size(); i++) {
            int[] pos = empties.get(i);
            map[pos[0]][pos[1]] = "O";
            dfs(count + 1, i + 1);
            map[pos[0]][pos[1]] = "X";
        }
    }

    static boolean isSafe() {
        for (int[] t : teachers) {
            int r = t[0], c = t[1];
            for (int dir = 0; dir < 4; dir++) {
                int newR = r, newC = c;
                while (true) {
                    newR += dr[dir];
                    newC += dc[dir];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= N || map[newR][newC].equals("O"))
                        break;
                    if (map[newR][newC].equals("S"))
                        return false;
                }
            }
        }
        return true;
    }
}
