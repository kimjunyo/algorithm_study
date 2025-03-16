package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//List<String>
//public class BOJ_3986_좋은_단어 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int cnt =0;
//		
//		for (int i = 1; i <= N; i++) {
//			List<String> stack = new ArrayList<>();
//		    String input = br.readLine(); 
//		    for (int j = 0; j < input.length(); j++) {
//
//		    	String check = String.valueOf(input.charAt(j));
//		    	if(!stack.isEmpty() && stack.get(stack.size()-1).equals(check)) {
//		    		stack.remove(stack.size()-1);
//		    	}else {
//		    		stack.add(check);
//		    	}
//		    }
//		    if(stack.isEmpty()) cnt++;
//		}
//		System.out.println(cnt);
//	}
//}

//Stack<Character>
public class BOJ_3986_좋은_단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt =0;
		
		for (int i = 1; i <= N; i++) {
			Stack<Character> stack = new Stack<>();
		    char[] input = br.readLine().toCharArray();
		    
		    for(char c : input) {
		    	if(!stack.isEmpty() && stack.peek()==c) {
		    		stack.pop();
		    	}else {
		    		stack.push(c);
		    	}
		    }
		    if(stack.isEmpty()) cnt++;
		}
		System.out.println(cnt);
	}
}
