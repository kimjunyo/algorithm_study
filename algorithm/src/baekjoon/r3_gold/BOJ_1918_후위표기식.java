package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('-', 1);
		priority.put('+', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		
		
		Stack<Character> stack = new Stack<>();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if(c=='(') {
				stack.push(c);
			}else if('A'<=c && c<= 'Z') {
				sb.append(c);
			}else if(c==')') {
				while(stack.peek() != '(' && !stack.isEmpty()) {
					char tmp= stack.pop();
					sb.append(tmp);
				}
				stack.pop();//괄호 버리기
			}else { //연산자
				if(stack.isEmpty()) stack.push(c);
				else {
					while(!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
						char tmp = stack.pop();
						sb.append(tmp);
					}
					stack.push(c);
					
				}
			}
		}
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb);
	}
}
