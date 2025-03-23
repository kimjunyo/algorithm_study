package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	static int[] node;
	
	private static int findNode(int num) {
		if(node[num]==num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static void union(int num1, int num2) {
		int root1 = findNode(num1);
		int root2 = findNode(num2);
		
		if(root1 != root2) {
			if(root1 < root2) node[root2] = root1;
			else node[root1] = root2;
		}
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		node = new int[N+1];
		Arrays.setAll(node, i->i);
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				if(connect ==1) {
					union(i, j);
				}
			}
		}
		
		boolean isPossible = true;
		st = new StringTokenizer(br.readLine());
		int checkNode =  findNode(Integer.parseInt(st.nextToken()));
		for(int i=1; i<M; i++) {
			if(checkNode != findNode(Integer.parseInt(st.nextToken()))) {
				isPossible = false;
				break;
			}
		}
		if(isPossible) System.out.println("YES");
		else System.out.println("NO");
	}
}
