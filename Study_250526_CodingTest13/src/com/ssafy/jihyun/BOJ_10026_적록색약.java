package com.ssafy.jihyun;

import java.io.*;
import java.util.*;

public class BOJ_10026_적록색약 {
	private static int N;
    private static char[][] map;
    private static boolean[][] visit;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
	
    private static void cntArea(int i, int j, boolean colorBlind) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visit[i][j] = true;
        char color = map[i][j];

        while (!q.isEmpty()) {
            int[] out = q.poll();
            int x = out[0], y = out[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[nx][ny]) {
                    char nextColor = map[nx][ny];

                    if (!colorBlind) {
                        if (nextColor == color) {
                            visit[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    } else {
                        if ((color == 'B' && nextColor == 'B') || (color != 'B' && nextColor != 'B')) {
                            visit[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		visit = new boolean[N][N];
        int normalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                	cntArea(i, j, false); 
                	normalCnt++;
                }
            }
        }

        visit = new boolean[N][N]; 
        int colorBlindCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                	cntArea(i, j, true); 
                	colorBlindCnt++;
                }
            }
        }
        
        System.out.println(normalCnt);
        System.out.println(colorBlindCnt);
	}
}
