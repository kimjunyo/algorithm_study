package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1033_칵테일 {
	
	static List<Integer>[] graph;
	static List<Integer>[] ratio;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N];
		ratio = new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
			ratio[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			ratio[b].add(p);
			ratio[b].add(q);
		}
		
		
		System.out.println(Arrays.toString(graph));
		System.out.println(Arrays.toString(ratio));
	}

}
