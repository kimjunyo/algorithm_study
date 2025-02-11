package com.ssafy.junyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수구하기_17298_2차 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Stack<Node> stack = new Stack<>();
		int idx = 0;
		
		st = new StringTokenizer(br.readLine());
		stack.add(new Node(idx++, Integer.parseInt(st.nextToken())));
		
		int[] result = new int[N];
		for(int i=0; i<N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().value < num) {
				result[stack.pop().index] = num;
			}
			
			stack.add(new Node(idx++, num));
		}
		
		for(int i : result) {
			if(i==0) System.out.print(-1 + " ");
			else System.out.print(i + " ");
		}
	}

	static class Node {
		int index;
		int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
	}
}
