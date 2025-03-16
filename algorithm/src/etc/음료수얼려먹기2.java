package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기2 {
	
	static int N;
	static int M;
	static int[][] ice;
	static int[] dx = {0,0,1,-1}; 	//동서남북
	static int[] dy = {1,-1,0,0};
	
	private static void dfs(int x, int y) {
		ice[y][x] =1; //방문체크
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0 || nx >= N || ny<0 || ny >= N || ice[ny][nx] ==1) {
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
		
		ice = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				ice[i][j] = input.charAt(j)-'0';
			}
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ice[i][j] == 0) {
					dfs(j,i);
					count++;
				}
			}
		}
		System.out.println("아이스크림 개수 : "+count+"개");
	}
}
