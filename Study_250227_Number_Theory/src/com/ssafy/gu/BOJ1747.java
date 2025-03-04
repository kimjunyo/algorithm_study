package com.ssafy.gu;

import java.util.Scanner;

public class BOJ1747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		outer:
		for (int i = N; true; i++) {
			String str = String.valueOf(i);
			boolean isPelindrome = false;
			
			if (str.length() == 1) {
				System.out.println(i);
				break;
			}
			
			for (int j = 0; j < str.length()/2; j++) {
				if (str.charAt(j) == str.charAt(str.length()-1-j)) {
					isPelindrome = true;
					continue;
				} else {
					isPelindrome = false;
					break;
				}
			}
			if (!isPelindrome) continue;
			
			int sqrt = (int)Math.sqrt(i);
			boolean[] visited = new boolean[sqrt+1];
			for (int j = 2; j <= sqrt; j++) {
				if (visited[j] == true) continue;
				for (int k = j+1; k <= sqrt; k++) {
					if (k%j==0) visited[k] = true;
				}
			}
			for (int j = 2; j <= sqrt; j++) {
				if (i%j == 0) continue outer;
			}
			System.out.println(i);
			break;
		}
	}
}
