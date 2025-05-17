package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();// 전체 문자열
		String str2 = br.readLine();// 폭발 문자열
		int length1 = str1.length(); // 전체 문자열의 길이
		int length2 = str2.length(); // 폭발 문자열의 길이

		int index = length2 - 1; // 폭발 문자열의 비교할 인덱스
		ArrayDeque<Character> result = new ArrayDeque<>();
		for (int i = 0; i < length1; i++) {
			char char1 = str1.charAt(i);
			result.add(char1);
			if (result.size() >= length2) {
				ArrayDeque<Character> remove = new ArrayDeque<>();

				while (index >= 0) {
					if (str2.charAt(index) == result.peekLast()) {
						remove.addFirst(result.pollLast());
						index--;
					} else {
						while (remove.size() > 0) {
							result.add(remove.pollFirst());
						}
						break;
					}
				}
				index = length2 - 1;
			}

		}

		// for
		StringBuilder answer = new StringBuilder();
		if (result.size() == 0) {
			System.out.println("FRULA");
			return;
		}
		while (result.size() > 0) {
			answer.append(result.pollFirst());
		}
		System.out.println(answer.toString().trim());
	}
}
