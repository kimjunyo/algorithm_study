package com.als.hyobin;

import java.util.Arrays;
import java.util.Scanner;

public class P008_좋다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).sorted().mapToInt(Integer::intValue)
				.toArray();

		int count = 0;
		
		//시간복잡도는 N^2longN으로 매우 좋지 않으나 수의 개수가 매우 적으므로 시간 제한 통과 가능
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i == j) continue;
				int index = 0;
				int start = i;
				int end = j;
				
				if(i > j) {
					start = j;
					end = i;	
				}
				
				index = Arrays.binarySearch(arr, 0, start, arr[i] - arr[j]);
				if(index >= 0) {
					count++;
					break;
				}
				
				index = Arrays.binarySearch(arr, start + 1, end, arr[i] - arr[j]);
				if(index >= 0) {
					count++;
					break;
				}
				
				index = Arrays.binarySearch(arr, end + 1, arr.length, arr[i] - arr[j]);
				if(index >= 0) {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
