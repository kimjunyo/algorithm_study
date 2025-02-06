package com.als.junyoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P009_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int numS = Integer.parseInt(st.nextToken());
		int numP = Integer.parseInt(st.nextToken());

		char[] dna = br.readLine().toCharArray();
		int[] protein = new int[4];
		int[] conditionProtein = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			conditionProtein[i] = Integer.parseInt(st.nextToken());

		// 초기값 설정 땜에 애먹음 
		int sum = 0;
		for (int i = 0; i < numP; i++) {
			plus(protein, dna[i]);
		}
		
		if (proteinSum(sum, protein, conditionProtein))
			sum++;

		for (int i = numP; i < numS; i++) {
			minus(protein, dna[i - numP]);
			plus(protein, dna[i]); 

			if (proteinSum(sum, protein, conditionProtein))
				sum++;
		}
		bw.write(sum + "\n");
		bw.flush();

		bw.close();
		br.close();
	}

	private static void minus(int[] arr, char s) {
		switch (s) {
		case 'A':
			arr[0]--;
			break;
		case 'C':
			arr[1]--;
			break;
		case 'G':
			arr[2]--;
			break;
		case 'T':
			arr[3]--;
		}
	}

	private static void plus(int[] arr, char s) {
		switch (s) {
		case 'A':
			arr[0]++;
			break;
		case 'C':
			arr[1]++;
			break;
		case 'G':
			arr[2]++;
			break;
		case 'T':
			arr[3]++;
		}
	}

	private static boolean proteinSum(int sum, int[] protein, int[] conditionProtein) {

		for (int i = 0; i < 4; i++) {
			if (protein[i] < conditionProtein[i])
				return false;
		}
		return true; // 오류
	}
}
