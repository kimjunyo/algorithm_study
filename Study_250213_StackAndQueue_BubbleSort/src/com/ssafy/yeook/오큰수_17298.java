package com.ssafy.yeook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int [n];
		int [] result = new int[n];
		
		//주어진 배열 저장.
		for(int i = 0;i<n;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		
		//1.스택의 top이 다음 수(num)보다 작으면 pop.
		//2.result배열에 pop한 수의 인덱스에 num저장. 
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(int i = 1 ;i<n;i++) {
			if(stack.size()>0) {
				int top = stack.peek();//index
				int num = arr[i];
				while(arr[top]<num) {
					//오큰수 발견한 인덱스는 pop.
					int index = stack.pop();
					result[index] = num;
					//stack에 아무것도 없으면 비교할것이 없으니까 break;
					if(stack.size()==0)break;
					top=stack.peek();
				}
				//num의 인덱스 저장.
				stack.push(i);
			}
		}
		while(stack.size()>0) {
			int index = stack.pop();
			result[index]=-1;
		}
		StringBuilder r=new StringBuilder();
		for(int i =0;i<n;i++) {
			r.append(result[i]).append(" ");
		}
		bw.write(r.toString().trim());
		bw.flush();
	}

}
