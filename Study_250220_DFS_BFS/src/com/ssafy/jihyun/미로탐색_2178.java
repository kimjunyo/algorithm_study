package com.ssafy.jihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
	
	static int N;
	static int M;
	static int[][] field;
	static Deque<int[]> deque  = new ArrayDeque<>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static int bfs(int i, int j) {
		deque.addLast(new int[] {i,j});
		
		while(!deque.isEmpty()) {
			int[] point = deque.pollFirst();
			
			if(point[0]==N-1 && point[1]==M-1)
				return field[point[0]][point[1]];
			
			for(int d= 0; d<4; d++) {
				int nx = dx[d] + point[0];
				int ny = dy[d] + point[1];
				if(0<= nx && nx<N && 0<= ny && ny < M && field[nx][ny] == 1) {
					deque.addLast(new int[] {nx,ny});
					field[nx][ny] += field[point[0]][point[1]];
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			char[] arr= input.toCharArray(); 
			for(int j=0; j<M; j++) {
				field[i][j] = arr[j]-'0';
			}
		} 
		System.out.println(bfs(0,0));
	}
}
