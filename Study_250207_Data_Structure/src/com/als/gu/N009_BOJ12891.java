package com.als.gu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N009_BOJ12891 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		int S = sc.nextInt();
//		int P = sc.nextInt();
//		String dna = sc.next();
//		int[] dnaMin = new int[4];
//		
//		for (int i = 0; i < 4; i++) {
//			dnaMin[i] = sc.nextInt();
//		}
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		String dna = st.nextToken();
		
		int[] dnaMin = new int[4];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) {
			dnaMin[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		outer:
		for (int i = 0; i+P-1 < S; i++) {
			int[] dnaCnt = new int[4];
			for (int j = i; j <= i+P-1; j++) {
				switch (dna.charAt(j)) {
				case 'A': {
					dnaCnt[0]++;
					break;
				}
				case 'C': {
					dnaCnt[1]++;
					break;
				}
				case 'G': {
					dnaCnt[2]++;
					break;
				}
				case 'T': {
					dnaCnt[3]++;
					break;
				}
				}
			}
			
			for (int j = 0; j < 4; j++) {
				if (dnaMin[j] > dnaCnt[j]) continue outer;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
