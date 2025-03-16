package baekjoon.r1_bronze;

import java.util.Arrays;
import java.util.Scanner;

//O(NlogN)이 나옴
//public class BOJ_2750_수_정렬하기 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int[] numArr = new int[n];
//		
//		for(int i=0; i<n; i++) {
//			numArr[i] = sc.nextInt();
//		}
//		
//		Arrays.sort(numArr);
//		for(int i=0; i<n; i++) {
//			System.out.println(numArr[i]);
//		}
//	}
//}

//O(N)
public class BOJ_2750_수_정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numArr = new int[2001];
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			numArr[num+1000]++; 
		}
		
		for(int i=0; i<2001; i++) {
			if(numArr[i]>0) System.out.println(i-1000);
		}
	}
}
