package com.als.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열_1874 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		//1~n까지 스택에 넣을 숫자.
		int num=1;
		
		StringBuilder result = new StringBuilder();
		Stack<Integer>stack = new Stack<>();
		//필요한숫자.
		int needNum = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		//주어진 숫자 가져오는 횟수.
		int count =1;
		//1 1 일때도실행되되록 do while사용.
		do {
			
			//필요한 숫자와 같을때까지 반복.
			while(num<=n) {
				stack.push(num);
				result.append("+\n");
				num++;
				if(stack.peek()==needNum) {
					break;
				}
			}
			//필요한 숫자와 스택의 맨위의 값이 같으면 결과에 추가.
			while(stack.size()>0) {
				if(stack.peek()==needNum) {
					stack.pop();
					result.append("-\n");
				}
				if(count<n) {
					needNum= Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
					count++;
				}
				if(stack.size()==0||stack.peek()!=needNum) {
					break;
				}
			}	
		}while(count<n);
		if(stack.size()==0&&count==n) {
			bw.write(result.toString().trim());
			bw.flush();
		}else {
			bw.write("NO");
			bw.flush();
		}
		
	}

}

