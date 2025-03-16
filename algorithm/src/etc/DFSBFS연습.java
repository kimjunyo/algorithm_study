package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class DFSBFS연습{
	
	static List<Integer>[] list;
	static boolean[] visited;
	static Deque<Integer> deque = new ArrayDeque<>();
	
	private static void dfs(int i) {
		if(visited[i]) return;
		
		visited[i] = true;
		System.out.print(i+" ");
		
		for(int node : list[i]) {
			if(!visited[node]) {
				dfs(node); 
			}
		}
	}
	
	private static void bfs(int i) {
		deque.offerLast(i);
		visited[i] = true;
		
		while(!deque.isEmpty()) {
			
			int point = deque.pollFirst(); //뽑고
			System.out.print(point + " ");
			
			for(int a : list[point]) {
				if(!visited[a]) {
					visited[a] = true;
					deque.offerLast(a);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}//초기화 해줬고
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u); //양방향 추가
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}//
}
