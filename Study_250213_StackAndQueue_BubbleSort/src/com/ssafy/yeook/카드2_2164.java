package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 카드2_2164 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		while (list.size() > 1) {
			// 맨 처음 값 제거하기
			list.removeFirst();
			// 요소 1개만 남으면 반복문 종료하기
			if (list.size() == 1) {
				break;
			}
			// 맨처음값 뒤로 이동하기
			list.add(list.removeFirst());
		}
		bw.write(String.valueOf(list.getFirst()));
		bw.flush();

	}

}
