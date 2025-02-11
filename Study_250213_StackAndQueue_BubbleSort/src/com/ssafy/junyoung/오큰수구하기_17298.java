package com.ssafy.junyoung;

import java.util.Scanner;
import java.util.Stack;

public class 오큰수구하기_17298 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		int N = scan.nextInt();
		int[] A = new int[N];
		int[] result = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = scan.nextInt();
		}
		
		for(int i=N-1; i>=0; i--) {
			while(!stack.isEmpty() && A[i]>stack.peek() ) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				result[i] = -1;
				stack.add(A[i]);
				continue;
			}
			
			result[i] = stack.peek();
			stack.add(A[i]);
		}
		for(int i: result) {
			System.out.print(i + " ");
		}
		
		scan.close();
		
	}
}
