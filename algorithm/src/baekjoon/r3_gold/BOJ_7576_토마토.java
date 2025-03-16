package baekjoon.r3_gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	
	static int[][] arr;
	static Deque<int[]> deque;
	static int cnt;
	static int M;
	static int N;
	static int[] dx = {0,0,1 ,-1}; 
	static int[] dy = {1,-1,0,0};
	
	private static boolean checkFull() {
	    for(int i=0; i<M; i++) {
	        for(int j=0; j<N; j++) {
	            if (arr[i][j] == 0) { 
	                return false;
	            }
	        }
	    }
	    return true;
	}

	private static void bfs() {
		cnt = 0;
		while(!deque.isEmpty()) {
			int size = deque.size();
			boolean check = false;
			
			for(int s = 0; s<size; s++) {
				int point[] = deque.pollFirst();
				
				for(int d=0; d<4; d++) {
					int nx = point[0] + dx[d];
					int ny = point[1] + dy[d];
					
					if(0<= nx && nx < M && 0<= ny && ny <N &&  arr[nx][ny] ==0) {
						arr[nx][ny] = 1;
						deque.offerLast(new int[] {nx,ny});
						check = true;
					}
				}
			}
			
			if(check) cnt++;
		}	
		if(checkFull()) {
			System.out.println(cnt); 
		}else System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		deque = new ArrayDeque<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					deque.offerLast(new int[] {i,j});
				}
			}
		}//
		
		if(checkFull()) {
			System.out.println(0);
			return;
		}
		
		
		for(int i=0; i<M; i++) {
		    for(int j=0; j<N; j++) {
		        if(arr[i][j] == 1) {
		            deque.offerLast(new int[]{i, j});
		        }
		    }
		}
		bfs();
	}
}
