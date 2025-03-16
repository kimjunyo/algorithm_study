package baekjoon.r1_bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] numArr = new int[n];
		
		for(int i=0; i<n; i++) {
			numArr[i] = sc.nextInt();
		}	
		
		int max = Arrays.stream(numArr).max().getAsInt();
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += (((double)numArr[i])/max)*100;
		}
		System.out.println(sum/n);
		sc.close();
	}

}
