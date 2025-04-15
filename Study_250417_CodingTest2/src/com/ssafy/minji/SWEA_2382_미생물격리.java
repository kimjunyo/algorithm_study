package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
	static int N;
	static int M;
	static int K;
	/////////////////////// list 안되겠다
	static List<Integer>[][] map;
	////////////////////////
	static int[][] group;
	static Map<Integer, int[]> dirs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new List[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = new ArrayList<Integer>();
				}
			}
			
			// r, c, 미생물 수, 이동방향
			group = new int[K][4];
			dirs = new HashMap<>();
			dirs.put(1,  new int[] {-1, 0});
			dirs.put(2,  new int[] {1, 0});
			dirs.put(3,  new int[] {0, -1});
			dirs.put(4,  new int[] {0, 1});
			
			
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < K ; j++) {
					group[i][j] = Integer.parseInt(st.nextToken());
					map[i][j].add(i);
				}
			}
			
			for(int time = 1 ; time <= M ; time++ ) {
				for(int g = 0 ; g < K ; g++) {
					move(g);
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
		}
	}// main
	
	
	static int[] dir;
	static int[] micro;
	static int r, c, mergeNum;
	static void move(int microNum) {
		micro = group[microNum];
		if(micro[2] == 0) {
			return;
		}
		
		dir = dirs.get(micro[3]);
		r = micro[0];
		c = micro[1];
//		map[r][c].
		
		r += dir[0];
		c += dir[1];
		
		if(r == 0 || c == 0 || r == N - 1 || c == N -1) {
			group[microNum][2] /= 2;
			
			if(micro[3] == 1) {
				micro[3] = 2;
			}else if(micro[3] == 2) {
				micro[3] = 1;
			}else if(micro[3] == 3) {
				micro[3] = 4;
			}else {
				micro[3] = 3;
			}
		}
		
//		if(map[r][c] != 0) {
//			mergeNum = map[r][c];
//			mer
//			
//		}
		
		
	}
	
}
