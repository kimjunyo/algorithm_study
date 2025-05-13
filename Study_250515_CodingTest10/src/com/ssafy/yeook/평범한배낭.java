package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	static int count, bagSize, max;// 물건의 수, 가방의 무게, 가치합의 최댓값.
	static Node[] arr; // 각 물건들의 무게와 가치 저장.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		bagSize = Integer.parseInt(st.nextToken());
		arr = new Node[count + 1]; //
		for (int i = 1; i <= count; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[i] = new Node(w, v);
		} // 저장끝.
		int dp[][] = new int[count + 1][bagSize + 1];

		for (int i = 1; i <= count; i++) { // 해당 i번째 물건까지 있을때,
			int w = arr[i].w; // i번째 물건의 무게.
			int v = arr[i].v; // i번째 물건의 가치.

			for (int size = 1; size <= bagSize; size++) { // 해당 가방크기까지의 최대 가치를dp에 저장.
				if (w <= size)
					// 현재물건의 가치+ 남는가방에 이전물건까지의 최대가치 vs 현재가방에 이전물건까지의 최대가치
					dp[i][size] = Math.max(v + dp[i - 1][size - w], dp[i - 1][size]);

				else
					dp[i][size] = dp[i - 1][size];

			}

		}
		System.out.println(dp[count][bagSize]);

	}// main

	static class Node {
		int w, v;// 무게,가치

		public Node(int w, int v) {
			this.w = w;
			this.v = v;
		}

	}

}
