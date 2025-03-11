package com.ssafy.siyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
	static int L;
	static int C;
	static char[] alphabets;
	static List<String> ans = new ArrayList<>();

	private static boolean isVowel(char c) {
		return "aeiou".indexOf(c) != -1;
	}
	private static void comb() {
		for (int mask = 0; mask < (1 << C); mask++) {
			if (Integer.bitCount(mask) == L) {
				StringBuilder sb = new StringBuilder();
				int consonant = 0, vowel = 0;
				for (int i = 0; i < C; i++) {
					if ((mask & (1 << i)) > 0) {
						sb.append(alphabets[i]);
						if (isVowel(alphabets[i])) vowel++;
						else consonant++;
					}
				}
				if (vowel >= 1 && consonant >= 2) {
					ans.add(sb.toString());
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabets = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabets);
		comb();
		ans.sort((o1, o2) -> o1.compareTo(o2));
		for (String s : ans) {
			System.out.println(s);
		}
	}

}
