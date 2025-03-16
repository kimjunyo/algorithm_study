package programmers.lv2;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
		String s = "()()"; // "()()" // "(())()" // "(())()" // "(()("
		Stack<Character> stack = new Stack<>();
		boolean answer = true;
		boolean stop = false;
		
		if(s.charAt(0) == ')') {
			stop = true;
		}else {
			for(int i=0; i<s.length(); i++) {
				if(!stack.isEmpty() && s.charAt(i) == ')') {
					if(stack.peek() =='(' ) stack.pop();
					else stack.push(s.charAt(i));
				}else if(stack.isEmpty() || s.charAt(i) =='(') {
					stack.push(s.charAt(i));
				}
			}
		}
		
		if(stop) answer = false;
		else {
			if(stack.isEmpty()) answer = true;
			else answer = false;
		}
		System.out.println(answer);

	}

}
