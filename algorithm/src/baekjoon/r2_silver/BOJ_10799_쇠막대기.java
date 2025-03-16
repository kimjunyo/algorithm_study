package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		String input = br.readLine();
		
		int result = 0;
		int cnt = 0;
		for(int i=0; i<input.length(); i++) {
			char check = input.charAt(i);
			if(check == '(') {
				s.push(check);
				cnt++;
			}else if(check == ')') {
				if(!s.isEmpty() && s.peek() == '(') { //레이
					cnt--;
					result += cnt;
					s.push(check);
				}else if(!s.isEmpty() && s.peek() == ')') {
					cnt--;
					result++;
					s.push(check);
				}
			}
			
		}
		System.out.println(result);
	}
}
