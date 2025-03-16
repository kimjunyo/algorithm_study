package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 미로탈출 {
	static int N;
	static int M;
	static int[] arr;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	//동, 서, 남, 북
	
	private static int bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {0,0});
		int r = 0;
		int c = 0;
		boolean run = true;
		while(run) {
			for(int d = 0; d<4; d++) {
				
				int nx = r + dx[d];
				int ny = c + dy[d];
				
				if(0<= nx && nx<N && 0<= ny && ny < M && arr[nx][ny] == 1) {
					deque.pollFirst();
					arr[nx][ny] = arr[r][c]+1;
					deque.push(new int[] {nx,ny});
					if(nx==N-1 && ny==M-1) {
						run = false;
					}
//					arr[r][c] =-1;
					r = nx;
					c = ny;
//					break;
				}
			}
		}
		return arr[N-1][M-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		System.out.println(bfs());
	}

}
