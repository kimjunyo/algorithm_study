package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_17070_파이프_옮기기1 {

    static int N, count;
    static int[][] map;

    public static void findWay(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }

        if (dir == 0 || dir == 2) {
            int nx = x;
            int ny = y + 1;
            if (ny < N && map[nx][ny] == 0) {
            	findWay(nx, ny, 0);
            }
        }

        if (dir == 1 || dir == 2) {
            int nx = x + 1;
            int ny = y;
            if (nx < N && map[nx][ny] == 0) {
            	findWay(nx, ny, 1);
            }
        }

        int nx = x + 1;
        int ny = y + 1;
        if (nx < N && ny < N && map[x][ny] == 0 && map[nx][y] == 0 && map[nx][ny] == 0) {
        	findWay(nx, ny, 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        findWay(0, 1, 0);
        System.out.println(count);
    }
}
