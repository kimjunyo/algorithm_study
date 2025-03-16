package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1224_계산기3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder infixToPostfix() throws IOException {
		
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('*', 2);
		priority.put('(', 0);

		Stack<Character> stack = new Stack<>();
		int len = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringBuilder postfix = new StringBuilder();
		
		for(int i=0; i<len; i++) {
			char a = input.charAt(i);
			
			if(a == '(') {
				stack.push(a);
			}else if('0'<= a && a<= '9') {
				postfix.append(a);
			}else if(a == ')') {
				while(stack.peek() != '(' && !stack.isEmpty()) {
					char output= stack.pop();
					postfix.append(output);
				}
				stack.pop();//괄호 버리기
			}else { //연산자
				if(stack.isEmpty()) {
					stack.push(a);
				}else {
					while(!stack.isEmpty()&& priority.get(stack.peek()) >= priority.get(a)) {
						char output= stack.pop();
						postfix.append(output);
					}
					stack.push(a);
				}
			}
		}
		
		while(!stack.isEmpty())
			postfix.append(stack.pop());
		
//		System.out.println(postfix);
		return postfix;
	}
	
	private static int calculate(StringBuilder postfix) {
		Stack<Integer> calStack = new Stack<>();
		for(int i=0; i<postfix.length(); i++) {
			int a = postfix.charAt(i);
			
			if('0'<= a && a<= '9') {
				calStack.push(a-'0');
			}else {
				int num1 = calStack.pop();
				int num2 = calStack.pop();
				int result = 0;
				if(a=='+') {
					result = num1 + num2;
				}else if(a=='*') {
					result = num1 * num2;
				}
				
				calStack.push(result);
			}
		}
		return calStack.pop();
	}

	public static void main(String[] args) throws IOException {
		
		for(int tc = 1; tc<=10; tc++) {
			StringBuilder postfix = infixToPostfix();
			int result = calculate(postfix);
			System.out.println("#"+tc+" "+result);

		}
	}
}
