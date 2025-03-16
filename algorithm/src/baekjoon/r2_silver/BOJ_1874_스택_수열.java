package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int num = 1;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(num<=input) {
				while(num<=input) {
					s.add(num++);
					sb.append("+").append("\n");
				}
				s.pop();
				sb.append("-").append("\n");
			}else {
				if(input == s.peek()) {
					s.pop();
					sb.append("-").append("\n");			
				}else {//input<peek
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println(sb);
	}
}
