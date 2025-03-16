package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2444_별찍기7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int star=0;
		int blank = 0;
		for(int i=1; i<= 2*n-1; i++) {
			star = (i<=n) ? 2*i-1 : 2*(2*n-i)-1 ;  
			blank = (i<=n) ? n-i : i-n;
			System.out.print(" ".repeat(blank));
			System.out.println("*".repeat(star));
		}
	}
}

/*
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

*/