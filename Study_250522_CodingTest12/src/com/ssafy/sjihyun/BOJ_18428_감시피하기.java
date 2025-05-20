package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_18428_감시_피하기 {
	
	private static int N;
	private static char[][] map;
	private static List<int[]> emptyIdx;
	private static List<int[]> teacherIdx;
	private static int[] set = new int[3];
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	private static boolean isValid(int[] set) {
	    char[][] copy = new char[N][N];
	    for (int i = 0; i < N; i++) copy[i] = map[i].clone();

	    int wall1X = emptyIdx.get(set[0])[0], wall1Y = emptyIdx.get(set[0])[1];
	    int wall2X = emptyIdx.get(set[1])[0], wall2Y = emptyIdx.get(set[1])[1];
	    int wall3X = emptyIdx.get(set[2])[0], wall3Y = emptyIdx.get(set[2])[1];

	    copy[wall1X][wall1Y] = copy[wall2X][wall2Y] = copy[wall3X][wall3Y] = 'O';

	    for (int[] t : teacherIdx) {
	        int x = t[0], y = t[1];
	        for (int d = 0; d < 4; d++) {
	            int nx = x, ny = y;
	            while (true) {
	                nx += dx[d];
	                ny += dy[d];
	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
	                if (copy[nx][ny] == 'O') break;
	                if (copy[nx][ny] == 'S') return false;
	            }
	        }
	    }
	    return true;
	}
	
	private static void findSet(int depth, int start) {
		if (depth == 3) {
			if(isValid(set)) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < emptyIdx.size(); i++) {
			set[depth] = i;
			findSet(depth + 1, i + 1); 
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		emptyIdx = new ArrayList<>();
		teacherIdx = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X') emptyIdx.add(new int[] {i, j});
				if(map[i][j] == 'T') teacherIdx.add(new int[] {i, j});
			}
		}
		findSet(0,0);
		System.out.println("NO");
	}
}
