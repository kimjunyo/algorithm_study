package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백트래킹 개오바야
public class SWEA_1767_프로세서_연결하기 {
	static int N;
	static int[][] arr;
	static List<Integer>[] graph;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	
	private static void dfs(int i, int j) {
		
		if(visit[i][j]) return;
		
		visit[i][j] = true;
		
		for(int d = 0; d<4; d++) {
			
			boolean canConnect = true;
			for (int p = 1; p <= N; p++) {
			    int nx = i + dx[d] * p;
			    int ny = j + dy[d] * p;
			    
			    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break; 
			    if (arr[nx][ny] != 0) { // 전선 설치 불가능
			        canConnect = false;
			        break;
			    }
			}
			
			if (canConnect) { 
	            // 실제로 전선을 설치하면서 다음 단계로 DFS 진행
	            for (int p = 1; p <= N; p++) {
	                int nx = i + dx[d] * p;
	                int ny = j + dy[d] * p;
	                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
	                arr[nx][ny] = 2; // 전선 표시
	            }
	            
	            dfs(i, j);
	            
	            // 백트래킹: 전선 제거
	            for (int p = 1; p <= N; p++) {
	                int nx = i + dx[d] * p;
	                int ny = j + dy[d] * p;
	                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
	                arr[nx][ny] = 0; // 전선 제거
	            }
			}

		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		 
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
			}
		} //배열 받고
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && (i != N-1 && i != 0 && j != N-1 && j != 0)) {
					dfs(i,j);
				}
			}
		}
		
	}

}
