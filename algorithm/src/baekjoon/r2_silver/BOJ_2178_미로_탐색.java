package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();	
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			if(point[0] ==N-1 && point[1] == M-1) break;
			
			for(int d =0; d<4; d++) {
				int nx = point[0] + dx[d];
				int ny = point[1] + dy[d];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && map[nx][ny]==1) {
					q.offer(new int[] {nx,ny});
					map[nx][ny] = map[point[0]][point[1]]+1; 
				}
			}
		}
		System.out.println(map[N-1][M-1]);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		bfs(0,0);
	}
}
