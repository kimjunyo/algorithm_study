package com.ssafy.gu;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ11726 {
	static BigInteger[] fResult = new BigInteger[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n+1; i++) {
			fResult[i] = BigInteger.valueOf(0);
		}
		System.out.println(func(n).remainder(BigInteger.valueOf(10007)));
	}

	private static BigInteger func(int n) {
		if (n == 1) return BigInteger.valueOf(1);
		if (n == 2) return BigInteger.valueOf(2);
		
		if (fResult[n-2].equals(BigInteger.valueOf(0))) fResult[n-2] = func(n-2);
		if (fResult[n-1].equals(BigInteger.valueOf(0))) fResult[n-1] = func(n-1);
		
		return fResult[n-2].add(fResult[n-1]);
	}
}
