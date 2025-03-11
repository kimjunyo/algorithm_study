package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호_만들기 {
	
	static char[] arr;
	static char[] result;
	static List<Character> vowel;
	static int L;
	static int C;
	static StringBuilder sb;
	
	private static boolean checkVowelConsonant(char[] result) {
		int cntVowel=0;
		for(int i=0; i<L; i++) {
			if(vowel.contains(result[i])) cntVowel++;
		}
		
		int cntConsonant = L-cntVowel;
		
		if(cntVowel >=1 && cntConsonant >=2)return true;
		else return false;
	}
	
	private static void findCombination(int depth, int last) {
		if(depth == L) {
			if(checkVowelConsonant(result)) {
				for(int i=0; i<L; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i = last+1; i<arr.length; i++) {
			result[depth] = arr[i];
			findCombination(depth+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		result = new char[L];
		vowel = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vowel.add(arr[i]);
			}
		}
		Arrays.sort(arr);
		findCombination(0,-1);
		System.out.println(sb);
	}
}
