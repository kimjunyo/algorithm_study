package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PN_18114_블랙프라이데이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] products = new int[N];
		for (int i = 0; i < N; i++) {
			products[i] = Integer.parseInt(st.nextToken());
			if (products[i] == C) {
				System.out.println(1);
				return;
			}
		}

		Arrays.sort(products);
		int temp = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				temp = products[i] + products[j];
				if (temp == C) {
					System.out.println(1);
					return;
				} else if (temp > C) {
					break;
				} else {
					for (int k = j + 1; k < N; k++) {
						if (products[k] == C - temp) {
							System.out.println(1);
							return;
						} else if (products[k] > C - temp) {
							break;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}