package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2442_별찍기5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt =0;
		for(int i=0; i<n; i++) {
			cnt = 2*i+1;
			System.out.print(" ".repeat(n-i-1));
			System.out.println("*".repeat(cnt));
		}
	}
}


/*
    *
   ***
  *****
 *******
*********

*/