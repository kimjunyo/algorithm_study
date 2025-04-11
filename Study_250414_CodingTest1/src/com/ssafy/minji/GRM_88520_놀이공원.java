package com.ssafy.minji;

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= T ; tc++){
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				int[][] map = new int[N][N];
				for(int i = 0 ; i < N ; i++){
					st = new StringTokenizer(br.readLine());
					for(int j = 0 ; j < N ;j++){
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}

				int min = 1_000_000;
				int trash;
					for(int i = 0 ; i <= N - K ; i++){
						trash = 0;
						// [i][0]을 좌측 상단 끝으로 하는 사각형의 쓰레기들
						for(int r = 0 ; r < K ; r++){
							for(int c = 0 ; c < K ; c++){
								trash += map[i + r][c];
							}
						}
						
						if(min > trash){
							min = trash;
						}
						
						for(int j = 1 ; j <= N - K ;j++){
							for(int r = 0 ; r < K ; r++){
								// [i][j - 1]을 상단 끝으로 하는 k만큼 세로 한 줄의 쓰레기들은 뺌
								trash -= map[i + r][j - 1];

								// [i][j + k - 1]을 상단 끝으로 하는 k만큼 세로 한 줄의 쓰레기들은 더함
								trash += map[i + r][j + K - 1];
							}
							
							if(min > trash){
								min = trash;
							}
						}
					}

				System.out.println(min);
		}
	}
}