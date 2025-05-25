package com.ssafy.jihyun;

import java.io.*;
import java.util.*;

public class BOJ_7579_토마토 {
	
	private static int N, M, H;
	private static int[][][] map;
	private static int[] dx = {0,0,1,-1,0,0};
	private static int[] dy = {1,-1,0,0,0,0};
	private static int[] dz = {0,0,0,0,-1,1};
	private static Queue<int[]> q;
	
	private static int bfs() {
		int day = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int[] out = q.poll();
				int x = out[0], y = out[1], z = out[2];
				
				for(int d = 0; d<6; d++) {
					int nx = x + dx[d], ny = y + dy[d], nz = z + dz[d];
					if(0<= nx && nx < N && 0<= ny && ny <M && 0<= nz && nz<H && map[nx][ny][nz] == 0) {
						q.offer(new int[] {nx, ny, nz});
						map[nx][ny][nz] = 1;
					}
				}
			}
			day++;
		}
		return day;
	}
	
	private static boolean isRipe() {
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j][k] ==0) return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		q = new ArrayDeque<>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] ==1 ) q.offer(new int[] {i,j,k});
				}
			}
		}
		if(isRipe()) System.out.println(0);
		else {
			int result = bfs();
			System.out.println(isRipe() ? result : -1); 
		}
	}
}
