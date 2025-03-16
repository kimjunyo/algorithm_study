package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int length = Integer.toString(n).length();
		int startRange = Math.max(1, n-(9*length));
		boolean found = false;
		
		for(int range= startRange; range<n; range++) {
			int sum =0;
			int check = range;
			for(int i=0; i<length; i++) {
				sum += (check%10);
				check /= 10;
				//char a = Integer.toString(range).charAt(i);
				//sum += (int)(a-'0');
			}
			if((sum +range) == n) {
				System.out.println(range);
				found = true;
				break;
			}
		}
		
		if(!found) System.out.println("0");
		sc.close();
	}

}
