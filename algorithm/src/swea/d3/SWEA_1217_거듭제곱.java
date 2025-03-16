package swea.d3;

import java.util.Scanner;

public class SWEA_1217_거듭제곱 {
	
	private static int power(int N, int M) {
		
		if(M==0) {
			return 1;
		}
		return N * power(N, M-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc =1; tc<=10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			
			int result = power(N,M);
			System.out.println("#"+tc+" "+result);
		}
	}
}

