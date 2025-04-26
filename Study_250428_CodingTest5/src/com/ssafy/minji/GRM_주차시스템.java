package com.ssafy.minji;

import java.io.*;
import java.util.*;
class GRM_주차시스템 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		int[] temp;
		int r, c, newR, newC;
		
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList();
		int max = 0;
		int score;
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < M ; j++){
				if(map[i][j] != 1 && !visited[i][j]){
					score = 0;
					que.add(new int[] {i, j});
		
					while(!que.isEmpty()){
						temp = que.poll();
						r = temp[0];
						c = temp[1];
						if(visited[r][c]){
							continue;
						}
						visited[r][c] = true;
						if(map[r][c] == 0){
							score++;
						}else{
							score -= 2;
						}
						
						for(int d = 0 ; d < 4 ; d++){
							newR = r + dr[d];
							newC = c + dc[d];
							if(newR >= 0 && newR < N && newC >= 0 && newC < M 
								 && !visited[newR][newC] && map[newR][newC] != 1){
								que.add(new int[] {newR, newC});
							}
						}
					}
					if(max < score){
						max = score;
					}
				}
			}
		}
		System.out.println(max);
	}
}