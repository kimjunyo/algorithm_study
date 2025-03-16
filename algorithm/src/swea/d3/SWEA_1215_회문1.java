package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1215_회문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) { // 수정
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<8; i++) { //넣기
				arr[i] = br.readLine().toCharArray();
			}
			
			int cnt =0;
			int check = 0;
			for(int i=0; i<8;i++) { //가로
				for(int j=0; j<8-(N-1); j++) {
					check = 0;
					while(check<(N/2)) {
						stack.push(arr[i][j+check]);
						check++;
					}
					if(N%2 !=0) check++;
					while(check<N) {
						if(stack.peek() == arr[i][j+check]) {
							stack.pop();
							check++;
						}else {
							break;
						}
					}
					if(stack.empty()) {
						cnt++;
					}
					stack.clear();
				}
			}
			for(int i=0; i<8;i++) { //세로
				for(int j=0; j<8-(N-1); j++) {
					check = 0;
					while(check<(N/2)) {
						stack.push(arr[j+check][i]);
						check++;
					}
					if(N%2 !=0) check++;
					while(check<N) {
						if(stack.peek() == arr[j+check][i]) {
							stack.pop();
							check++;
						}else {
							break;
						}
					}
					if(stack.empty()) {
						cnt++;
					}
					stack.clear();
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}///
	}
}