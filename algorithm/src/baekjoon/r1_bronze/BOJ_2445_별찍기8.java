package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2445_별찍기8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int star =0;
		for(int i=1; i<=2*n-1; i++) {
			star = (i<=n) ? i: 2*n -i;
			System.out.print("*".repeat(star));
			System.out.print(" ".repeat((n-star)*2));
			System.out.println("*".repeat(star));
			
		}
	}

}



/*
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

*/