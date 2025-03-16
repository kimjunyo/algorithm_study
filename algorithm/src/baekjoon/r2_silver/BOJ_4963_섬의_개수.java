package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의_개수 {
	
	static int w;
	static int h;
	static int[][] map;
	static int[] dx = {0,0,1,-1,-1,1,1,-1};
	static int[] dy = {1,-1,0,0,1,1,-1,-1};
	
	
	private static void dfs(int i, int j) {
		for(int d=0; d<8; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(0<= nx && nx < w && 0<= ny && ny < h && map[nx][ny]==1) {
				map[nx][ny] = 0;
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[w][h];
			
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<h; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					if(map[i][j] ==1) {
						map[i][j]=0;
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}
