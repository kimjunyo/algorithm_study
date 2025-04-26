package com.ssafy.minji;

import java.io.*;
import java.util.*;
class GRM_불이야 { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		Queue<int[]> que = new LinkedList();
		boolean[][] visited = new boolean[R][C];
		String str;
		for(int i = 0 ; i < R ; i++){
			str = br.readLine();
			for(int j = 0 ; j < C ; j++){
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == '@'){
					que.add(new int[] {i, j, 0});
				}
			}
		}

		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		int[] temp;
		int r, c, far, newR, newC;
		int ans = -1;

		find:
		while(!que.isEmpty()){
			temp = que.poll();
			r = temp[0];
			c = temp[1];
			far = temp[2];
			if(visited[r][c]){
				continue;
			}
			visited[r][c] = true;
			
			for(int i = 0 ; i < 4 ; i++){
				newR = r + dr[i];
				newC = c + dc[i];

				if(newR >= 0 && newR < R && newC >= 0 && newC < C &&	!visited[newR][newC]){
					if(map[newR][newC] == '.'){
						que.add(new int[] {newR, newC, far + 1});
					}else if(map[newR][newC] == '&'){
						ans = far;
						break find;
					}
				}
			}
		}

		System.out.println(ans);
	}
}