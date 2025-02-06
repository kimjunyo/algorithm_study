package com.als.hyobin;

import java.util.Arrays;
import java.util.Scanner;

public class P007_주몽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine(); // 공백제거
		
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.sorted().mapToInt(Integer::intValue).toArray();
		
		int count = 0;
		for(int i : arr) {	
			if(Arrays.binarySearch(arr, M - i) >= 0)
				count++;
		}
		System.out.println(count / 2);
	}
}
