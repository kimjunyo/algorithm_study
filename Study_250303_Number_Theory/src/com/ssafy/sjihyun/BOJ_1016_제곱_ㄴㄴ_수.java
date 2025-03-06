package com.ssafy.sjihyun;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1016_제곱_ㄴㄴ_수 {

	static long min, max;
	static long cnt;
	static boolean[] checkNum; //true : 제곱수마즘
	

	private static void findNum() {
		for (long i = 2; i*i <= max; i++) {
			long square = i * i;

			long start = ((min+square-1) / square) * square;

			for (long j = start; j <= max; j += square) { 
				if (!checkNum[(int) (j - min)]) { 
					checkNum[(int) (j - min)] = true;
					cnt--;
				}
			}
			//System.out.println(Arrays.toString(checkNum));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		min = sc.nextLong();
		max = sc.nextLong();
		sc.close();
		
		cnt = max - min + 1;
		checkNum = new boolean[(int)cnt];
		findNum();
		System.out.println(cnt);
	}
}
