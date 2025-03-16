package baekjoon.r2_silver;
import java.util.Scanner;

public class BOJ_9012_괄호 {
	private static int top;
	private static boolean check;
	
	public static void pop() {
		if(top==-1) check = false;
		--top;
	}
	
	public static void push() {
		++top;
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine(); // 개행 문자 처리 (nextInt() 뒤에 nextLine() 호출)
		for(int i=0; i<T; i++) {
			check = true;
			top = -1;
			String PT = sc.nextLine();
			for(char input : PT.toCharArray()) {
				if(input == '(') push();
				else if(input == ')') pop();
				
				if(!check) {
					break;
				}
			}	
			if(check && top==-1) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
