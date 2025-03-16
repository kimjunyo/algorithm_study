package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA_1218_괄호_짝짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		for(int tc = 1; tc<=10; tc++) {//수정
			int T = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			boolean check = true;
			
//			System.out.println(Arrays.toString(arr));

			
			for(char c : arr) {
				if(c == '{' || c == '[' || c =='(' || c == '<') {
					stack.push(c);
				} else if(c ==  '}' && !stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else if(c ==  ']' && !stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else if(c ==  ')' && !stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else if(c ==  '>' && !stack.isEmpty() && stack.peek() == '<') {
					stack.pop();
				} else {
					check = false;
					break;
				}
			}
			if(!check) {
				System.out.println("#"+tc+" "+0);
			}else {
				System.out.println("#"+tc+" "+1);
			}
		}
		
	}

}
