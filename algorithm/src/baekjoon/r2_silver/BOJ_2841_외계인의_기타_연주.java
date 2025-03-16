package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841_외계인의_기타_연주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer>[] s = new Stack[6];
		
		for(int i=0; i<6; i++) {
			s[i] = new Stack<>();
		}
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int cnt = 0; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken())-1;
			int num = Integer.parseInt(st.nextToken());
			
			boolean isSame = false;
			if(s[line].isEmpty()) {
				s[line].push(num);
				cnt++;
			}else {
				int check = s[line].peek();
				
				if(check<num) {
					s[line].push(num);
					cnt++;
				}else { //check>num
					while(!s[line].isEmpty() && s[line].peek()>=num) {
						if(s[line].peek()==num) {
							isSame = true;
							break;
						}
						s[line].pop();
						cnt++;
					}
					
					if(!isSame) {
						s[line].push(num);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
