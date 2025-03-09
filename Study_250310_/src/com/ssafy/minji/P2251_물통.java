package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P2251_물통 {
	static int A;
	static int B;
	static int C;
	static Set<String> cases;
	static Set<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cases = new TreeSet<>();
		result = new TreeSet<>();
		water(0, 0, C);
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

	static void water(int a, int b, int c) {
		String str = a + "," + b + "," + c;
		if (cases.contains(str)) {
			return;
		}
		cases.add(str);
		if (a == 0 && !result.contains(c)) {
			result.add(c);
		}

		int[] temp = new int[2];
		if (a != A) {
			if(c != 0) {
				temp = move(A, a, c);
				water(temp[0], b, temp[1]);
			}
			if(b != 0) {
				temp = move(A, a, b);
				water(temp[0], temp[1], c);
			}
		}
		
		if (b != B) {
			if(a != 0) {
				temp = move(B, b, a);
				water(temp[1], temp[0], c);
			}
			if(c != 0) {
				temp = move(B, b, c);
				water(a, temp[0], temp[1]);
			}
		}
		
		if (c != C) {
			if(a != 0) {
				temp = move(C, c, a);
				water(temp[1], b, temp[0]);
			}
			if(b != 0) {
				temp = move(C, c, b);
				water(a, temp[1], temp[0]);
			}
		}
	}
	
	static int[] move(int maxTo, int to, int from) {
		if(to + from <= maxTo) {
			to = to + from;
			from = 0;
		}else {
			from = from - (maxTo - to);
			to = maxTo;
		}
		
		return new int[] {to, from};
	}
}
