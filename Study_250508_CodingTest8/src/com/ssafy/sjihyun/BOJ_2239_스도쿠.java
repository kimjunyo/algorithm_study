package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_2239_스도쿠 {
	
	static int[][] map;
	static int[] missing;
	static List<int[]> blank;
	
	private static void fillBlank(int depth) {
		if(depth == blank.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0); 
		}
		
		int[] points = blank.get(depth);
		int x = points[0], y = points[1];
		int block = 18 + (x / 3) * 3 + (y / 3);
		
		int nums =  missing[x] & missing[9 + y] & missing[block];
		
		for (int num = 1; num <= 9; num++) {
	        if ((nums & (1 << num)) != 0) {
	        	map[x][y] = num;
	        	
	        	missing[x] &= ~(1 << num);
	        	missing[9 + y] &= ~(1 << num);
	        	missing[block] &= ~(1 << num);

	        	fillBlank(depth+1);
	        	
	        	missing[x] |= (1 << num);
	        	missing[9 + y] |= (1 << num);
	        	missing[block] |= (1 << num);
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		missing = new int[27];
		Arrays.fill(missing, (1<<10) -1);
		
		blank = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = input.charAt(j)-'0';
				missing[i] &= ~(1<<map[i][j]);
				missing[9 + j] &= ~(1 << map[i][j]);

				int block = 18 + (i / 3) * 3 + (j / 3);
				missing[block] &= ~(1<<map[i][j]);
				
				if(map[i][j] == 0) blank.add(new int[] {i,j});
			}
		}
		fillBlank(0);
	}
}
