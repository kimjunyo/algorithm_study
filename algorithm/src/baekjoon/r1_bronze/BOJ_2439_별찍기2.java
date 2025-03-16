package baekjoon.r1_bronze;

import java.util.Scanner;

public class BOJ_2439_별찍기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.print(" ".repeat(n-i));
			System.out.println("*".repeat(i));
		}
	}
}
