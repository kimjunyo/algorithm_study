package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P025_13023_친구관계파악하기 {
	static List<Integer>[] nodesPerNode;
	static boolean[] visited;
	static boolean exists;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nodesPerNode = new List[N];
		visited = new boolean[N];
		exists = false;
		int temp1 = 0;
		int temp2 = 0;
		
		for(int i = 0 ; i < N ; i++) {
			nodesPerNode[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			nodesPerNode[temp1].add(temp2);
			nodesPerNode[temp2].add(temp1);
		}
		
		for(int i = 0 ; i < N ; i++) {
			count(i, 0);
			if(exists) {
				break;
			}
		}
		System.out.println(exists == true ? 1 : 0);
	}
	
	static void count(int idx, int cnt) {
		if(cnt == 4 || exists) {
			exists = true;
			return;
		}
		visited[idx] = true;
		for(int node : nodesPerNode[idx]) {
			if(!visited[node]) {
				count(node, cnt + 1);
			}
		}
		visited[idx] = false;
		
	}
}
