package baekjoon.r1_bronze;
import java.util.Scanner;

public class BOJ_11720_숫자의합 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String numList = sc.next();
		int sum = 0;
		for(int i=0; i<n; i++) 
			sum += numList.charAt(i)-'0';
		System.out.println(sum);
		
		sc.close();
	}
}
