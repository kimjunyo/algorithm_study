package swea.d1;

import java.util.Scanner;


public class SWEA_2072_홀수만_더하기 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] A = new int[10];
			for(int i=0;i<10;i++) {
				A[i] = sc.nextInt();
			}
				
			int sum = 0;
			
			for(int j=0; j<10; j++) {
				if(A[j]%2!=0) {
					sum += A[j];
				}	
			}
			System.out.println("#"+test_case+" "+sum);	
		


		}
	}
}