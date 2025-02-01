package com.als.jihyun;
import java.util.Arrays;
import java.util.Scanner;

public class P002_평균_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double[] numArr = new double[n];
		
		for(int i=0; i<n; i++) {
			numArr[i] = sc.nextInt();
		}
	
		double max = Arrays.stream(numArr).max().getAsDouble();
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += numArr[i]/max;
		}
		System.out.println(sum*100/n);
	}
}
