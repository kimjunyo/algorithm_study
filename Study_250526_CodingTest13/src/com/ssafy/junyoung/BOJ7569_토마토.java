package com.ssafy.junyoung;

import java.util.*;
import java.io.*;

// 92% ㅇㅔ서 틀림..
public class BOJ7569_토마토 {
    static int M, N, H, count;
    static int[] dm = {-1, 1, 0, 0, 0, 0};
    static int[] dn = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[][][] box;
    static boolean isChanged, isExistEikDa;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        count = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                        isExistEikDa = true;
                    }
                }
            }
        }

        bfs(queue);

        // 토마토가 안 익은 상태와 나머지 다 -1인 경우를 캐치하지 못함..
        if (!isChanged && !isExistEikDa) {
            bw.write("-1");
            bw.flush();
            return;
        } else if (!isChanged) {
            bw.write("0");
            bw.flush();
            return;
        }

        bw.write(isEikDa() + "");
        bw.flush();
    }

    private static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int n = 0; n < size; n++) {
                int[] node = queue.poll();

                for (int k = 0; k < 6; k++) {
                    int nh = node[0] + dh[k];
                    int nn = node[1] + dn[k];
                    int nm = node[2] + dm[k];

                    if (nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
                    if (box[nh][nn][nm] == 1 || box[nh][nn][nm] == -1) continue;

                    queue.offer(new int[]{nh, nn, nm});
                    box[nh][nn][nm] = 1;
                    isChanged = true;
                }
            }
            count++;
        }
    }

    private static int isEikDa() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) return -1;
                }
            }
        }
        return count - 1;
    }
}
