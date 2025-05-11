package com.ssafy.sjihyun;

import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {

	private static List<Sharks> sharkList;
	private static int R,C, sharkSum=0; 

	private static class Sharks {
		int r, c, s, d, z;

		public Sharks(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	// (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다.
	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
	
	private static void moveShark() {
		
		boolean[][] map = new boolean[R+1][C+1];
	    for(int i=0; i<sharkList.size(); i++) {
	    	Sharks shark = sharkList.get(i);
	        int r = shark.r;
	        int c = shark.c;
	        int s = shark.s;
	        int d = shark.d;
	        int z = shark.z;

	        int newR = r, newC = c, newD = d;

	        switch (d) {
	            case 1: {
	                int cycle = (R - 1) * 2;
	                int idx = (R - r + s) % cycle; 

	                if (idx < R) {
	                    newR = R - idx;
	                } else {
	                    newR = idx - R + 2;
	                    newD = 2;
	                }
	                break;
	            }
	            case 2: { 
	                int cycle = (R - 1) * 2;
	                int idx = (r - 1 + s) % cycle;

	                if (idx < R) {
	                    newR = idx + 1;
	                } else {
	                    newR = 2 * R - idx - 1;
	                    newD = 1;
	                }
	                break;
	            }
	            case 3: { 
	                int cycle = (C - 1) * 2;
	                int idx = (c - 1 + s) % cycle;

	                if (idx < C) {
	                    newC = idx + 1;
	                } else {
	                    newC = 2 * C - idx - 1;
	                    newD = 4;
	                }
	                break;
	            }
	            case 4: {
	                int cycle = (C - 1) * 2;
	                int idx = (C - c + s) % cycle;

	                if (idx < C) {
	                    newC = C - idx;
	                } else {
	                    newC = idx - C + 2;
	                    newD = 3;
	                }
	                break;
	            }
	        }
	        
	        shark.r = newR;
	        shark.c = newC;
	        shark.d = newD;
	        
	        if (!map[newR][newC]) map[newR][newC] = true;
	        else removeShark(newR, newC, i);
	    }
	}
	
	private static void removeShark(int r, int c, int to) {
		int max = Integer.MIN_VALUE, removeIdx = -1;
		for (int i = 0; i <= to; i++) {
		    Sharks shark = sharkList.get(i);
		    if (shark.r == r && shark.c == c) {
		        if (shark.z > max) {
		            max = shark.z;
		            removeIdx = -1; 
		        } else removeIdx = i;
		    }
		}
		if (removeIdx != -1) sharkList.remove(removeIdx);
	}
	
	private static int findShark(int num) {
		int result = 0, depth = Integer.MAX_VALUE, idx = -1;
		for(int i=0; i<sharkList.size(); i++) {
			Sharks shark = sharkList.get(i);
			int r = shark.r;
	        int c = shark.c;
	        
	        if(c==i && depth > r) {
	        	depth = r;
        		idx = i;
	        }
		}
		
		if(idx != -1) {
			sharkSum += sharkList.get(idx).z;
			sharkList.remove(idx);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		sharkList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharkList.add(new Sharks(r, c, s, d, z));
		}
		
		for (int i = 1; i <= C; i++) {
			findShark(i);
			moveShark();
		}
		System.out.println(sharkSum);
	}
}
