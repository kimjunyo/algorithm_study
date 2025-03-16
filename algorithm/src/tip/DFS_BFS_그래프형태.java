package tip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_BFS_그래프형태 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static Deque<Integer> deque;
	
	
	private static void dfs(int i) {
		if(visited[i]) return;
		visited[i] = true;
		for(int v : list[i]) {
			if(!visited[v]) {
				dfs(v);
			}
		}
	}
	
	private static void bfs(int i) {
		deque = new ArrayDeque<>();
		deque.offerLast(i);
		visited[i] = true;
		
		while(!deque.isEmpty()) {
			int point = deque.pollFirst();
			
			for(int v : list[point]) {
				if(!visited[v]) {
					visited[v] = true;
					deque.offerLast(v);
				}
			}
		}
	}
	
	
	public static void main(String[] args)  throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}//초기화 해줌
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u); //양방향 추가
		}
		
		int count = 0;
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
}
