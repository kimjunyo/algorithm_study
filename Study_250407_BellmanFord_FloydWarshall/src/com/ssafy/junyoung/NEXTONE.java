package com.ssafy.junyoung;

import java.util.*;

public class NEXTONE {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] islands = {{1, 2, 4}, {4, 2, 4}, {3, 1, 0}};

        int N = islands.length;
        int M = islands[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[islands.length][islands[0].length];
        int answer = 0;

        s1:
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int value = cur[2];
                System.out.println(x + " " + y + " " + value);

                if (x == N - 1 && y == M - 1) {
                    answer = value;
                    break s1;
                }

                // j로 표현
                for (int j = 0; j < 4 && islands[x][y] - 1 >= 0; j++) {
                    int direction = (islands[x][y] - 1 + j) % 4;
                    int newX = x + dr[direction];
                    int newY = y + dc[direction];

                    if (newX < 0 || newX >= N || newY < 0 || newY >= M || visited[newX][newY]) continue;

                    visited[newX][newY] = true;
                    int nextValue = j + 1;

                    for (int k = 0; k < 4 && islands[newX][newY] - 1 >= 0; k++) {
                        int newDirection = (islands[newX][newY] - 1 + k) % 4;
                        int newnewX = newX + dr[newDirection];
                        int newnewY = newY + dc[newDirection];

                        if (newnewX == x && newnewY == y && nextValue > k + 1) {
                            nextValue = k + 1;
                            islands[newX][newY] = (islands[newX][newY] + k) % 4 + 1;
                        }
                    }
                    queue.offer(new int[]{newX, newY, value + nextValue});
                }
            }
        }
        System.out.println(answer);
    }
}
