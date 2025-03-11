package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
	static int[] sel; // 인덱스번호로 저장.
	static int n, k;
	static String[] arr;
	static StringBuilder result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken()); // 암호길이
		n = Integer.parseInt(st.nextToken());// 알파벳갯수.
		result = new StringBuilder();
		sel = new int[k];
		st = new StringTokenizer(br.readLine());
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken();
		} // 주어진 알파벳 저장.

		Arrays.sort(arr);// 알파벳순으로 저장.

		comb(0, 0);
		System.out.println(result.toString().trim());

	}

	public static void comb(int selIndex, int arrIndex) {
		if (selIndex == k) {
			int vcount = 0;// 모음갯수.
			int ccount = 0;// 자음갯수.

			// 자음과 모음 갯수 세기.
			for (int i = 0; i < k; i++) {
				String a = arr[sel[i]];
				if (a.equals("a") || a.equals("e") || a.equals("i") || a.equals("o") || a.equals("u")) {
					vcount++;
				} else {
					ccount++;
				}
			}

			if (vcount >= 1 && ccount >= 2) {
				for (int i = 0; i < k; i++) {
					result.append(arr[sel[i]]);
				}
				result.append("\n");
			}

			return;
		}

		if (arrIndex == n) {
			return;
		}

		sel[selIndex] = arrIndex;
		comb(selIndex + 1, arrIndex + 1);
		comb(selIndex, arrIndex + 1);
	}

}
