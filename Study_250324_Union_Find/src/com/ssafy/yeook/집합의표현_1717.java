package com.ssafy.yeook;



	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class 집합의표현_1717 {
		public static int[] arr;

		public static void main(String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1]; // 인덱스 =숫자. 해당 인덱스의 루트 노드를 저장.
			for (int i = 0; i <= n; i++) {
				arr[i] = i; // 초기에는 자기 자신이 부모이다.
			}
			StringBuilder result = new StringBuilder();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (k == 0) { // 합치기
					union(a, b);
				} else {// 포함여부 확인.
					if (find(a) == find(b)) {
						result.append("YES").append("\n");
					} else {
						result.append("NO").append("\n");

					}
				}
			} // 주어진 값들 처리
			System.out.print(result.toString());
		}// main

		public static void union(int a, int b) {
			int rootA = find(a); // a의 루트노드 찾기
			int rootB = find(b);// b의 루트노드 찾기
			if (rootA != rootB) {
				arr[rootB] = rootA;
			}
		}

		public static int find(int a) {
			if (arr[a] == a) { // 루트노드가 자기자신이라면 자기자신 반환.
				return a;
			} else {
				arr[a] = find(arr[a]);
				return arr[a]; // 부모노드로 올라가며 루트노드 반환.
			}
		}
	}
