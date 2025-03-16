package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {
	static int[][] field;
	static int N;
	static int M;
	static int[] dx = {0,0,1 ,-1}; //동 서 남 북 
	static int[] dy = {1,-1,0,0};
	
	private static void dfs(int x, int y) {
		field[y][x] = 1; //1로 바꿔줌
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			
			//x,y랑 i,j 헷갈리지 말 것
			if(nx<0 || nx >= M || ny<0 || ny>= N || field[ny][nx] ==1 ) {
				continue;
			}
			dfs(nx,ny);
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				field[i][j] = input.charAt(j)-'0';
			}
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] ==0) {
					dfs(j,i);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}//
}
