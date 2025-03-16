package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
	static boolean[][][] visit;
	static Set<Integer> set;
	static int capacity[];
	
	/* 6가지 경우의수 
	 * 
	 * a -> b
	 * a -> c
	 * b -> a
	 * b -> c
	 * c -> a
	 * c -> b
	 * 
	 */
	
	private static void bfs(int a, int b, int c) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {a, b, c});
	    
	    visit[a][b][c] = true;  
	    while(!q.isEmpty()) {
	    	int[] out = q.poll();
	    	int wa = out[0], wb = out[1], wc = out[2];
	    	
	    	if (wa == 0)  set.add(wc);  
	    	
	    	for (int from = 0; from < 3; from++) {   
	    	    for (int to = 0; to < 3; to++) {    
	    	        if (from != to) { 
	    	            int[] next = move(wa, wb, wc, from, to); 
	    	            int na = next[0], nb = next[1], nc = next[2];

	    	            if (!visit[na][nb][nc]) { 
	    	                visit[na][nb][nc] = true;
	    	                q.offer(new int[]{na, nb, nc});
	    	            }
	    	        }
	    	    }
	    	}
	    }
	}
	
	private static int[] move(int a, int b, int c, int from, int to) {
	    int[] buckets = {a, b, c};

	    int move = Math.min(buckets[from], capacity[to] - buckets[to]); 
	    buckets[from] -= move;
	    buckets[to] += move;
	    return buckets;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		capacity = new int[] {A,B,C};
		set = new HashSet<>();
		visit = new boolean[201][201][201]; 
		
		bfs(0, 0, C);
		
		List<Integer> result = new ArrayList<>(set);
		result.sort(null); 

		for (int num : result) {
		    sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
