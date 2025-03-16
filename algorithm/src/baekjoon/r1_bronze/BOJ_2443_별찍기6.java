package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2443_별찍기6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt =0;
		for(int i=n; i>0; i--) {
			cnt = 2*i-1;
			System.out.print(" ".repeat(n-i));
			System.out.println("*".repeat(cnt));
			
		}

	}

}

/*
*********
 *******
  *****
   ***
    *
*/