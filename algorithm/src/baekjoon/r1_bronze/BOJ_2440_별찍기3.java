package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2440_별찍기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=n; i>0; i--) {
			System.out.println("*".repeat(i));
		}
		
		
	}

}

/*
*****
****
***
**
*
*/