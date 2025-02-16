package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 신기한소수_2023 {
	// 조합 순환.
	static int[] rest = { 1, 3, 7, 9 };
	// 맨처음 올수 있는 수.
	static int[] first = { 2, 3, 5, 7 };
	// 결과저장.
	static StringBuilder result = new StringBuilder();

	static int n = 1;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		if (n == 1) {
			for (int elm : first) {
				result.append(elm).append("\n");
			}
			bw.write(result.toString().trim());
			bw.flush();
			return;
		}

		for (int elm : first) {
			dfs(elm, 1);
		}
		bw.write(result.toString().trim());
		bw.flush();
	}

	// 신기한 소수인지 확인.
	public static void dfs(int num, int count) {
		if (count == n) {
			result.append(num).append("\n");
			return;
		}

		// 1,3,7,9추가하면서 소수인지확인.
		for (int elm : rest) {
			int newNum = num * 10 + elm;
			if (isPrime(newNum))
				dfs(newNum, count + 1);
		}
	}

	// 소수인지 판별함.
	public static boolean isPrime(int num) {
		if (num < 2)
			return false;

		// 제곱근까지 모든 수를 나누어보면서 나누어떨어지지 않으면 소수임.
		// 제곱근까지인 이유 : 제곱근 이후에는 이전과 대칭이므로.
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
