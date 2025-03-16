package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1991_트리_순회 {
	
	static int[][] graph;
	static int[] node;
	static StringBuilder sb;
	
	private static void preOrder(int num) {
		sb.append((char)(node[num]+'A'-1));
		for(int v : graph[num]) {
			if(v != 0) preOrder(v);
		}
	}
	
	private static void inOrder(int num) {
		
		if(graph[num][0] != 0) {
			inOrder(graph[num][0]);
		}
		
		sb.append((char)(node[num]+'A'-1));
		
		if(graph[num][1] != 0) {
			inOrder(graph[num][1]);
		}
	}
	
	private static void postOrder(int num) {
		for(int v : graph[num]) {
			if(v != 0) postOrder(v);
		}
		sb.append((char)(node[num]+'A'-1));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		graph = new int[N+1][2];
		node = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int check1 = st.nextToken().charAt(0)-'A'+1;
			node[check1] = check1;
			int cnt =0;
			while(cnt<2) {
				int check2 = st.nextToken().charAt(0)-'A'+1;
				if(check2 != -18) graph[check1][cnt++] = check2;
				else cnt++;
			}
		}
		//System.out.println(Arrays.toString(node));
		//System.out.println(Arrays.deepToString(graph));
		preOrder(1);
		sb.append("\n");
		inOrder(1);
		sb.append("\n");
		postOrder(1);
		System.out.println(sb);
	}
}
