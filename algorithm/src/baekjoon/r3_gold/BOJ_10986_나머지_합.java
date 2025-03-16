package baekjoon.r3_gold;
//
//import java.util.Scanner;
//
//public class BOJ_10986_나머지_합 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt()+1;
//		int m = sc.nextInt();
//		
//		long numArr[] = new long[n];
//		long sumArr[] = new long[n];
//		long reCount[] = new long[m];
//		
//		for(int i=1; i<n; i++) {
//			numArr[i] = sc.nextInt();
//			sumArr[i] = sumArr[i-1] + numArr[i];
//			reCount[(int)(sumArr[i] % m)]++;
//		}
//		
//		long check = reCount[0];
//		for(long num : reCount) {
//			if(num>1) {
//				check += (num*(num-1))/2;
//			}
//		}
//		
//		System.out.println(check);	
//	}
//}
//
////배열 크기가 int 한계를 넘으면 ArrayIndexOutOfBoundsException 발생할 수 있음!! 이것도 꼭 확인할 것 


public class BOJ_10986_나머지_합 {
	public static void main(String[] args) {
		
	}
	
	
	
}




















