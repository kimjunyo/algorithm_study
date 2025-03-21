package com.ssafy.junyeong.boj1717_집합의표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sel = Integer.parseInt(st.nextToken());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			switch(sel) {
			case 0:
				union(first, second);
				break;
			case 1:
				bw.write((find(first) == find(second)) ? ("YES\n") : ("NO\n"));
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}
}
