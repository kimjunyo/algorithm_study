package com.ssafy.yeook;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 여행가자_1976 {
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 도시의 수
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());// 여행계획에 속한 도시들의 수.
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;// 처음에는 자기자신을 부모로 저장.
		}

		for (int a = 1; a <= n; a++) {
			st = new StringTokenizer(br.readLine());

			for (int b = 1; b <= n; b++) {
				if (a == b)
					st.nextToken();// 자기자신
				else {
					int i = Integer.parseInt(st.nextToken());
					if (i == 1) {
						union(a, b);
					}
				}
			}
		} // 주어진 입력통해서 arr에 루트노드 연결.

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m - 1; i++) {
			int b = Integer.parseInt(st.nextToken());
			int rootA = find(a);
			int rootB = find(b);

			if (rootA != rootB) {
				System.out.println("NO");
				return;
			}
			a = b;
		}

		System.out.println("YES");

	}// main

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootB < rootA)
				arr[rootA] = rootB;
			else
				arr[rootB] = rootA;
		}
	}

	public static int find(int a) {
		if (arr[a] == a) {
			return a;
		}

		return arr[a] = find(arr[a]);
	}

}
