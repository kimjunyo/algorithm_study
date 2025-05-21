package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기 {
	static int N;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		// dir : 1 = 가로 / 2 = 세로 / 3 = 대각선
		DFS(1, 1);
		System.out.println(ans);
	}
	
	static void DFS(int rc, int dir) {
		int r = rc / N;
		int c = rc % N;
		if(r == N - 1 && c == N - 1) {
			ans++;
			return;
		}
		
		int newRC;
		if(dir == 1) {			// 가로 : 오른쪽/대각선
			newRC = right(rc);
			if(newRC != -1) {
				DFS(newRC, 1);
			}
			
			newRC = diag(rc);
			if(newRC != -1) {
				DFS(newRC, 3);
			}
		}else if(dir == 2) {	// 세로 : 아래/대각선
			newRC = down(rc);
			if(newRC != -1) {
				DFS(newRC, 2);
			}
			
			newRC = diag(rc);
			if(newRC != -1) {
				DFS(newRC, 3);
			}
		}else {					// 대각선 : 오른쪽, 아래, 대각선
			newRC = right(rc);
			if(newRC != -1) {
				DFS(newRC, 1);
			}
			
			newRC = down(rc);
			if(newRC != -1) {
				DFS(newRC, 2);
			}
			
			newRC = diag(rc);
			if(newRC != -1) {
				DFS(newRC, 3);
			}
		}
	}
	
	static int right(int rc) {
		int r = rc / N;
		int c = rc % N;
		if(c + 1 < N && map[r][c + 1] == 0) {
			c++;
			return r * N + c;
		}
		return -1;
	}
	
	static int down(int rc) {
		int r = rc / N;
		int c = rc % N;
		if(r + 1 < N && map[r + 1][c] == 0) {
			r++;
			return r * N + c;
		}
		return -1;
	}
	
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	static int diag(int rc) {
		int r = rc / N;
		int c = rc % N;
		int newR, newC;
		boolean ok = true;
		
		for(int d = 0 ; d < 3 ; d++) {
			newR = r + dr[d];
			newC = c + dc[d];
			if(newR >= N || newC >= N || map[newR][newC] != 0) {
				ok = false;
				continue;
			}
		}
		if(ok) {
			r++;
			c++;
			return r * N + c;
		}
		return -1;
	}
}
