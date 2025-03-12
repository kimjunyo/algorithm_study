package com.ssafy.kyungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static char[] arr;
	static int L;
	static int MIN_VOWEL = 1;
	static int MIN_CONSONANT = 2;
//	char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 3~C
		// 최소 1개의 모음 + 최소 2개의 자음
		// 알파벳순
		L = Integer.parseInt(st.nextToken());
		// L~15
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		backtracking(0, 0, 0, new char[L]);

		System.out.println();
	}

	private static void backtracking(int length, int start, int vowel, char[] carr) {
		if ((vowel + L - length) < MIN_VOWEL)
			return;
		// 자음의 숫자가 최소 자음수보다 작고, 존재하는 자음과 더 채워야하는 문자의 합이 채워야하는 자음보다 작을때
		if ((length - vowel) < MIN_CONSONANT && (length - vowel + L - length) < MIN_CONSONANT) {
			return;
		}

		if (length == L) {
			for (int i = 0; i < carr.length; i++) {
				System.out.print(carr[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i < arr.length; i++) {
			boolean isVowel = arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u';
			carr[length] = arr[i];
			backtracking(length + 1, i + 1, isVowel ? vowel + 1 : vowel, carr);
		}
	}
}