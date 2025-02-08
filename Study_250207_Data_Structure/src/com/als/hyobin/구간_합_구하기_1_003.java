package com.als.hyobin;

import java.io.*;

public class 구간_합_구하기_1_003 {
	private static int[] getPartialSum(int[] numbers) {
		int[] partialSum = new int[numbers.length + 1];
		for (int i = 1; i < partialSum.length; i++) {
			partialSum[i] = partialSum[i - 1] + numbers[i - 1];
		}
		return partialSum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		int[] numbers = new int[N];

		int idx = 0;
		for (String n : br.readLine().split(" "))
			numbers[idx++] = Integer.parseInt(n);

		int[] partialSum = getPartialSum(numbers);

		for (int m = 0; m < M; m++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]);
			int j = Integer.parseInt(ij[1]);
			bw.write(Integer.toString(partialSum[j] - partialSum[i - 1]) + "\n");
		}

		bw.flush();
	}
}
