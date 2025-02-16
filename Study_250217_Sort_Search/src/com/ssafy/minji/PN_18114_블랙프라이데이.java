package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PN_18114_블랙프라이데이 {
	static boolean free = false;
	static int[] products;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		products = new int[N];
		for (int i = 0; i < N; i++) {
			products[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(products);
		
		//////////////// unsolved ////////////////////////
	}

	static void buyFree(int idx, int cnt, int weight) {
		if (cnt > 3 || idx >= products.length || weight <= 0)
			return;

		if (weight == 0) {
			free = true;
			return;
		}

		buyFree(idx + 1, cnt++, weight - products[idx]);
		buyFree(idx + 1, cnt, weight);
	}
}