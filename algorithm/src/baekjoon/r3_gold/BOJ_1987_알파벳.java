package baekjoon.r3_gold;
// 중복 알파벳 만나면 종료하고
// 백트래킹이므로 dfs이용해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class BOJ_1987_알파벳 {
	static int R, C;
	static char[][] arr; 
	//static boolean[][] visit;
	static Set<Character> set = new HashSet<>();  //방문한 알파벳 넣는 셋
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int maxDepth = 0; // 최대 깊이 저장
	
	
	//일단 알파벳 없이 구현
	private static void dfs(int x, int y, int depth) {
		
		maxDepth = Math.max(maxDepth, depth); // 최대 깊이 갱신
		
		//if(visit[x][y]) return; //사실 필요없음
		//visit[x][y] = true; //방문체크
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0<=nx && nx < R && 0<= ny && ny < C) {
				if(!set.contains(arr[nx][ny])) {
					set.add(arr[nx][ny]); //알파벳 추가해줌
					dfs(nx,ny,depth+1);
					
					//백
					//visit[nx][ny] = false; // 방문 해제해줌
					set.remove(arr[nx][ny]); //헤당 알파벳 제거해줌
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		arr = new char[R][C];
//		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray(); 
        }
		
		set.add(arr[0][0]); //셋에 A 넣어줌
		dfs(0,0,1);
		
		System.out.println(maxDepth);
	}//
}
