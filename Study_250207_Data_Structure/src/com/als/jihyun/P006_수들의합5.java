import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//왜 스캐너냐면,,,,강의실에서 풀을 안했,,,,,,^_ㅠ
		int n = sc.nextInt();
		int[] numArr = new int[n];
		
		int front=1;
		int rear =1;
		int sum = 1;
		int count =1;
		
		while(rear != n) {
			if(sum == n) {
				count ++;
				sum += ++rear;
			}else if(sum > n) {
				sum -= front++;		
			}else { //sum<n
				sum += ++rear;
			}
		}	
		System.out.println(count);	
	}
}