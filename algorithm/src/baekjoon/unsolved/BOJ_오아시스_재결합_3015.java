package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_오아시스_재결합_3015 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0; 
		int first = Integer.parseInt(br.readLine());
		int second = Integer.parseInt(br.readLine());
		if(first<=second) s.push(second);
		else {
			s.push(first);
			s.push(second);
		}//2개 미리 넣어놓기
		cnt++;
		
		for(int i=2; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(s.isEmpty()) s.push(num);
			else if(s.peek() < num) { //입력값이 더 큼
				cnt += s.size();
				while(s.size() != 1) {
					s.pop();
				}
				s.push(num);
			}else if(s.peek() == num) {
				cnt += s.size();
				s.push(num);
			}else if(s.peek() > num) { //입력값이 더 작음
				s.push(num);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
