package com.als.jihyun;
import java.util.Scanner;

public class P001_숫자의_합_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String numList = sc.next();
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += numList.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
