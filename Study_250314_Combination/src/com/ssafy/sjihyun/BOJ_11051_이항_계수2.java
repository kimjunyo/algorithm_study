package com.ssafy.sjihyun;

import java.util.Scanner;
import java.math.BigInteger;


//public class BOJ_11051_이항_계수2 {
//	
//	private static int calCombination(int n, int k) {
//		if(n-k==1 || k==1) return n;
//		else if(k==0 || n==k) return 1;
//		return calCombination(n-1, k) + calCombination(n-1, k-1);
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int K = sc.nextInt();
//		
//		int result = calCombination(N, K);
//		System.out.println(result%10007);
//	}
//}

//
//public class BOJ_11051_이항_계수2 {
//    private static double combination(int n, int k) {
//        if (k == 0 || k == n) return 1; 
//        else if(n-k==1) return n;
//        long result = 1; 
//        for (int i = 0; i < k; i++) {
//            result *= (n - i);  
//            result /= (i + 1);   
//        }
//        return result%10007;
//    }
//    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//        K = K>N-K? K : N-K; 
//        
//        System.out.println((int)combination(N,K));
//    }
//}



public class BOJ_11051_이항_계수2 {
    private static BigInteger combination(int n, int k) {
        BigInteger result = BigInteger.ONE;
        
        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                           .divide(BigInteger.valueOf(i + 1));
        }
        //System.out.println(result);
        return result.mod(BigInteger.valueOf(10007));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        K = K>N-K? K : N-K; 
        System.out.println(combination(N, K));
    }
}

