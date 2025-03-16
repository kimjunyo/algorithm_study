package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정_거리의_도시_찾기 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int K;
	static List<Integer> result = new ArrayList<>();
	
	private static void bfs(int X) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(X);
		visit[X] = true;
		
		int level = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				int node = q.poll();
				if(level == K) {
					result.add(node);
					continue;
				}
				
				for(int n : graph[node]) {
					if(!visit[n]) {
						q.offer(n);
						visit[n] = true;
					}
				}
			}
			level++;
			if(level>K) return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
		}
		
		bfs(X);
		if(result.size()==0) System.out.println(-1);
		else {
			Collections.sort(result);
			for(int r : result) {
				System.out.println(r);
			}
		}
	}
}