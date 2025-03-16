package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_개수 {
	
	static List<Integer>[] graph; // List<Integer>[] graph;는 리스트들의 배열이다!
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];  // 배열 선언
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
		    graph[i] = new ArrayList<>(); //여기서 각 노드별 리스트 생성! //각 칸을 초기화해줘야함
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		} //입력받은 요소 다 넣었음
		
		
		//System.out.println(graph.length); //항상 N+1
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
				
			}
		}
		System.out.println(cnt);
	}
	
	
	private static void dfs(int i) {
		if(visited[i]) {
			return;
		}
		
		visited[i] = true;
		for(int v: graph[i]) { //graph[i] 에 저장된 모든 요소를 확인함 // 1같은 경우 2랑 5모두
			if(visited[v]==false) {
				dfs(v);
			}
		}
	}
}