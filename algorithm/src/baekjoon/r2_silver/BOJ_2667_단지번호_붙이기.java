package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_단지번호_붙이기 {
	
	static int N;
	static char[][] field;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt=0;
	
	private static void dfs(int i, int j) {
		field[i][j] = '0';
		cnt++;
		
		for(int d=0; d<4; d++) {
			int nx = dx[d] + i;
			int ny = dy[d] + j;
			
			if(0<= nx && nx<N && 0<= ny && ny<N && field[nx][ny]=='1') {
				dfs(nx,ny);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		field = new char[N][N];
		
		for(int i=0; i<N; i++) {
			field[i] = br.readLine().toCharArray();
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(field[i][j] =='1') {
					cnt=0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int a : list) {
			System.out.println(a);
		}
	}
}
