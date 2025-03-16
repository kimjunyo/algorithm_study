package jungol.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JOL_1005_가장_큰_소인수 {
	static int max;
	static boolean[] isNotPrime;
	
	private static void findPrime(int num) {
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i=2; i*i<=max; i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i; j<=max; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		max =0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		isNotPrime = new boolean[max+1];
		findPrime(max);
		
		int maxPrime = 0, maxNum = 0;
		for(int i=max; i>1; i--) {
			for(int j=0; j<arr.length; j++) {
				if(!isNotPrime[i] && arr[j] % i ==0) {
					if(i>maxPrime) {
						maxPrime = i;
						maxNum = arr[j];
					}
				}
			}
		}
		System.out.println(maxNum);
	}
}
