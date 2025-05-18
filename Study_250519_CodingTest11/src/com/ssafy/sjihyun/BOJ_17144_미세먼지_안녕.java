package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class Main {
	
	private static int R,C;
	private static int[][] map;
	private static int top, bottom;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	private static void diffusion() {
		int[][] tmpMap = new int[R][C];
		
		for(int x=0; x<R; x++) {
			for(int y=0; y<C; y++) {
				if(map[x][y] != -1 && map[x][y] != 0) {
					int diff = map[x][y] /5;
					int cnt = 0;
					for(int d = 0; d<4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if(0<= nx && nx < R && 0<= ny && ny < C && map[nx][ny] != -1) {
							cnt++;
							tmpMap[nx][ny] += diff;
						}
					}
					tmpMap[x][y] += map[x][y] - cnt * diff;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = tmpMap[i][j];
			}
		}
		map[top][0] = map[bottom][0] = -1;
	}
	
	private static void airPurifier() {
		for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
		for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
		for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
		map[top][1] = 0; 

		for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
		map[bottom][1] = 0; 
	}
	
	private static int remainDust() {
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1) result += map[i][j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		top = bottom = -1;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					if (top == -1) top = i;
					else bottom = i;
				}
				map[i][j] = num;
			}
		}
		
		for(int i=1; i<=T; i++) {
			diffusion();
			airPurifier();
		}
		System.out.println(remainDust());
	}
}
