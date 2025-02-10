package com.als.hyobin;

import java.io.*;
import java.util.stream.Stream;

public class 구간_합_구하기_2_004 {
	private static int[][] getPartialSum(int[][] table) {
		int[][] partialSumTable = new int[table.length + 1][table[0].length + 1];
		for (int x = 1; x < table.length + 1; x++) {
			for (int y = 1; y < table[0].length + 1; y++) {
				partialSumTable[x][y] = table[x - 1][y - 1] + partialSumTable[x][y - 1] + partialSumTable[x - 1][y]
						- partialSumTable[x - 1][y - 1];
			}
		}
		return partialSumTable;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		int[][] table = new int[N][N];
		for (int x = 0; x < N; x++) {
			String[] line = br.readLine().split(" ");
			for (int y = 0; y < N; y++) {
				table[x][y] = Integer.parseInt(line[y]);
			}
		}

		int[][] partialSumTable = getPartialSum(table);

		for (int m = 0; m < M; m++) {
			int[] xy = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int x1 = xy[0];
			int y1 = xy[1];
			int x2 = xy[2];
			int y2 = xy[3];
			int result = partialSumTable[x2][y2] - (partialSumTable[x2][y1 - 1] + partialSumTable[x1 - 1][y2])
					+ partialSumTable[x1 - 1][y1 - 1];
			bw.write(Integer.toString(result) + "\n");
		}
		bw.flush();
	}
}
