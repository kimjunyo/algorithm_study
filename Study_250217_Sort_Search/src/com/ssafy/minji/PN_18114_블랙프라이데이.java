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
		int N = Integer.parseInt(st.nextToken()) + 1;
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] products = new int[N];
		for (int i = 1; i < N; i++) {
			products[i] = Integer.parseInt(st.nextToken());
			if (products[i] == C) {
				System.out.println(1);
				return;
			}
		}

		Arrays.sort(products);
		int weight = 0;
		int start = 0;
		int end = N - 1;
		for (int i = 0; i < N - 2; i++) {
			weight = C - products[i];
			start = i + 1;
			end = N - 1;
			while(start < end) {
				if(products[start] + products[end] > weight) {
					end--;
				}else if(products[start] + products[end] < weight) {
					start++;
				}else {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}
}