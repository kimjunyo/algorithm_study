package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1759_암호만들기 {
	static int L;
	static int C;
	static char[] arr;
	static List<List<Character>> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		result = new ArrayList<>();

		comb(0, 0, new ArrayList<>(), false, 0);

		for (int i = result.size() - 1; i >= 0; i--) {
			for (char c : result.get(i)) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

	static void comb(int idx, int cnt, List list, boolean contains, int notVow) {
		if (cnt == L && contains && notVow >= 2) {
			result.add(new ArrayList<>(list));
			return;
		}

		if (idx == C) {
			return;
		}

		comb(idx + 1, cnt, new ArrayList<>(list), contains, notVow);
		list.add(arr[idx]);
		if (arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u') {
			contains = true;
		}else {
			notVow++;
		}
		comb(idx + 1, cnt + 1, new ArrayList<>(list), contains,notVow);
	}
}
