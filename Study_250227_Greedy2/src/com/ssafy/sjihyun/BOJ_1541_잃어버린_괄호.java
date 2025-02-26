package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String rInput = input.replace("-", " - ").replace("+", " + ");
		Deque<String> dq = new ArrayDeque<>();
		
		System.out.println(input);
		System.out.println(rInput);
		System.out.println(rInput.length());
		
		StringTokenizer st = new StringTokenizer(rInput);
		boolean op = false;
		while(st.hasMoreTokens()) {
			String check = st.nextToken();
			if(!check.equals("+")) {
				if(check.equals("-")) op = true;
				dq.offerLast(check);
			}
			else if(check.equals("+")) {
				if(op) {
					String check2 = st.nextToken();
					String tmp = dq.pollLast();
					dq.offerLast(String.valueOf(Integer.parseInt(check2)+Integer.parseInt(tmp)));
				}else {
					dq.offer(check);
				}
			}
		}
		
		System.out.println(dq);
		int result = 0;
		while(!dq.isEmpty()) {
			String tmp = dq.pollFirst();
			if(tmp.equals("-")) {
				result -= Integer.parseInt(dq.pollFirst());
			}else if(tmp.equals("+")) {
				result += Integer.parseInt(dq.pollFirst());
			}else {
				result += Integer.parseInt(tmp);
			}
			
		}
		System.out.println(dq);
		System.out.println(result);
	}
}
