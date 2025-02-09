package com.als.hyobin;

import java.util.Scanner;

public class P009_DNA_비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();

		char[] arr = sc.next().toCharArray();

		int A = sc.nextInt();
		int C = sc.nextInt();
		int G = sc.nextInt();
		int T = sc.nextInt();

		int[] conditionArr = { A, C, G, T };

		int count = 0;
		int[] cntArr = new int[4];
		for (int i = 0; i < P; i++) {
			if (arr[i] == 'A')
				cntArr[0]++;
			else if (arr[i] == 'C')
				cntArr[1]++;
			else if (arr[i] == 'G')
				cntArr[2]++;
			else
				cntArr[3]++;
		}

		if (cntArr[0] >= conditionArr[0] && cntArr[1] >= conditionArr[1] && cntArr[2] >= conditionArr[2]
				&& cntArr[3] >= conditionArr[3])
			count++;

		for (int i = 1; i < S - P + 1; i++) {
			if (arr[i - 1] == 'A')
				cntArr[0]--;
			else if (arr[i - 1] == 'C')
				cntArr[1]--;
			else if (arr[i - 1] == 'G')
				cntArr[2]--;
			else
				cntArr[3]--;

			if (arr[i + P - 1] == 'A')
				cntArr[0]++;
			else if (arr[i + P - 1] == 'C')
				cntArr[1]++;
			else if (arr[i + P - 1] == 'G')
				cntArr[2]++;
			else
				cntArr[3]++;

			if (cntArr[0] >= conditionArr[0] && cntArr[1] >= conditionArr[1] && cntArr[2] >= conditionArr[2]
					&& cntArr[3] >= conditionArr[3])
				count++;
		}

//		System.out.println(Arrays.toString(cntArr));
		System.out.println(count);

	}
}
