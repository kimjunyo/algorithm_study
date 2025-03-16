package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA_5356_의석이의_세로로_말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> q1 = new ArrayDeque<>();
		Deque<Character> q2 = new ArrayDeque<>();
		Deque<Character> q3 = new ArrayDeque<>();
		Deque<Character> q4 = new ArrayDeque<>();
		Deque<Character> q5 = new ArrayDeque<>();
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc =1; tc<=T; tc++) {
			sb.append("#" +tc + " ");
			
			//1번 
			String input1 = br.readLine();
			for(int j=0; j<input1.length(); j++) {
				q1.offer(input1.charAt(j));
				
			}
			//2번 
			String input2 = br.readLine();
			for(int j=0; j<input2.length(); j++) {
				q2.offer(input2.charAt(j));
				
			}
			//3번 
			String input3 = br.readLine();
			for(int j=0; j<input3.length(); j++) {
				q3.offer(input3.charAt(j));
				
			}
			//4번 
			String input4 = br.readLine();
			for(int j=0; j<input4.length(); j++) {
				q4.offer(input4.charAt(j));
				
			}
			//5번 
			String input5 = br.readLine();
			for(int j=0; j<input5.length(); j++) {
				q5.offer(input5.charAt(j));
				
			}
			
			while(!q1.isEmpty() || !q2.isEmpty() || !q3.isEmpty() || !q4.isEmpty() || !q5.isEmpty()) {
				if(!q1.isEmpty()) {
					sb.append(q1.pollFirst());
				}
				if(!q2.isEmpty()) {
					sb.append(q2.pollFirst());
				}
				if(!q3.isEmpty()) {
					sb.append(q3.pollFirst());
				}
				if(!q4.isEmpty()) {
					sb.append(q4.pollFirst());
				}
				if(!q5.isEmpty()) {
					sb.append(q5.pollFirst());
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
		
	}

}
