package com.ssafy.minji;

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// [0] : 세로 / [1] : 가로
		int[][][] map = new int[N + 1][N + 1][2];

		Map<Character, int[]> dir = new HashMap();
		dir.put('U', new int[] {-1, 0});
		dir.put('D', new int[] {1, 0});
		dir.put('R', new int[] {0, 1});
		dir.put('L', new int[] {0, -1});
		long cnt = 0;
		int r, c;
		char d;
		for(int i = 0 ; i < M; i++){
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			d = st.nextToken().charAt(0);
			while(r >= 0 && r < N && c >= 0 && c < N){
				if(d == 'U' || d == 'D'){
					map[r][c][0]++;
					cnt += map[r][c][1];
				} else{
					map[r][c][1]++;
					cnt += map[r][c][0];
				}
				r += dir.get(d)[0];
				c += dir.get(d)[1];
			}
		}
		System.out.println(cnt);
	}
}