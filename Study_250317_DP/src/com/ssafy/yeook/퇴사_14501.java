package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
	public static int[][] arr;
	public static int n;
	public static int price;

	public static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 상담기간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 상담시 가격.
		} // 배열 저장.
		result = 0;
		recur(0, 0);
		System.out.println(result);

	}

	public static void recur(int curIndex, int price) { // 현재 인덱스, 누적된 금액

		if (curIndex >= n) {
			result = Math.max(result, price);
			return;
		}
		// 상담기간이 남은 기간보다 짧거나 같은경우.
		if (curIndex + arr[curIndex][0] <= n) {
			recur(curIndex + arr[curIndex][0], price + arr[curIndex][1]);

		}
		// 선택안한경우.
		recur(curIndex + 1, price);

	}
}
