package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int tc = 1; tc<=T; tc++) {
			int len = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int i = 0; i<len; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num!= 0) {
					stack.push(num);
					sum+=num;
				}else if(!stack.empty() && num ==0){
					int sub = stack.pop();
					sum-=sub;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
