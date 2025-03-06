package com.ssafy.sjihyun;

import java.util.Scanner;

public class BOJ_1747_소수_팰린드롬 {

	static final int MAXINT = 1100000;
	
	static boolean[] isNotPrime = new boolean[MAXINT+1];

    private static void checkPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i * i <= MAXINT; i++) {
            if(!isNotPrime[i]) {
                for(int j = i * i; j <= MAXINT; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
    
    private static boolean isPalindrome(String str){
    	String reversed = new StringBuilder(str).reverse().toString();
    	if(reversed.equals(str)) return true;
    	return false;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		checkPrime();
		
		for(int i=N; i<MAXINT; i++) {
			if(!isNotPrime[i] && isPalindrome(String.valueOf(i))) {
				System.out.println(i);
				return;
			}
		}
	}
}
