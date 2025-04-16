package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
	static int N;
	static int M;
	static int K;
	static Map<Integer, Set<Integer>> map;
	static int[][] group;
	static Map<Integer, int[]> dirs;
	static List<Integer> merge;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new HashMap<Integer, Set<Integer>>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map.put(i * N + j, new HashSet<>());
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
				for(int j = 0 ; j < 4 ; j++) {
					group[i][j] = Integer.parseInt(st.nextToken());
				}
				map.get(group[i][0] * N + group[i][1]).add(i);
			}
			
			merge = new ArrayList<>();
			for(int time = 1 ; time <= M ; time++ ) {
				merge.clear();
				
				for(int g = 0 ; g < K ; g++) {
					move(g);
				}
				
				for(int meetPoint : merge) {
					int maxVal = 0;
					int maxMicro = -1;
					for(int microNum : map.get(meetPoint)) {
						if(maxVal < group[microNum][2]) {
							maxVal = group[microNum][2];
							maxMicro = microNum;
						}
					}
					
					for(int microNum : map.get(meetPoint)) {
						if(microNum == maxMicro) {
							continue;
						}
						group[maxMicro][2] += group[microNum][2];
						group[microNum][2] = 0;
					}
				}
			}
			
			int microSum = 0;
			for(int i = 0 ; i < K ; i++) {
				microSum += group[i][2];
			}
			
			System.out.println("#" + tc + " " + microSum);
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
		map.get(r * N + c).remove(microNum);
		
		r += dir[0];
		c += dir[1];
		group[microNum][0] = r;
		group[microNum][1] = c;
		
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
		map.get(r * N + c).add(microNum);
		if(map.get(r * N + c).size() > 1) {
			merge.add(r * N + c);
		}
	}
	
}
