package programmers.lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class 가장먼노드 {
	static int n = 8;
	//static int[][] edge = new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
	static int[][] edge = new int[][] { { 1, 2}, {1, 3 }, { 1, 4 }, {2,5}, {2,6}, { 2,7 }, { 3,8} };

	static List<Integer>[] graph;
	static Deque<Integer> deque;
	static boolean[] visit;
	static int maxCnt;
	static int size;
	
	private static void bfs(int num) {
		deque = new ArrayDeque<>();
		deque.offerLast(num);
		visit[num] = true;
		
		maxCnt = 0; 
		size = 0;
		while(!deque.isEmpty()) {
			size = deque.size(); maxCnt = size;
			for(int i=0; i<size; i++) {
				int point = deque.pollFirst();
				
				for(int v : graph[point]) {
					if(!visit[v]) {
						visit[v] = true;
						deque.offerLast(v);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		graph = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int[] a: edge) {
			int u = a[0];
			int v = a[1];
			graph[u].add(v);
			graph[v].add(u);
		}
		
		System.out.println(Arrays.toString(graph));
		bfs(1);
		System.out.println(maxCnt);
	}
}
