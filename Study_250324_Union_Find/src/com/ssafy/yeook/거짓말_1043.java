package com.ssafy.yeook;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말_1043 {
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 전체 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 파티의 수

		parent = new int[n + 1]; // 0번은 지민. 루트노드를 저장하는 배열
		Set[] arr = new HashSet[n + 1]; // 속해있는 파티들을 저장. (파티를 인덱스로 저장.)
		for (int i = 0; i <= n; i++) { // 처음엔 루트를 자기자신으로 설정.
			parent[i] = i;
			arr[i] = new HashSet();
		}
		Set<Integer> parties = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());// 진실을 아는 사람의 수
		// 진실을 아는 사람들의 루트를 0(지민)으로 저장.
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			parent[num] = 0;
		}

		for (int i = 0; i < m; i++) {
			parties.add(i);
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			arr[a].add(i);
			for (int j = 0; j < count - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				arr[b].add(i);// 파티번호를 저장.
				union(a, b);
				a = b;
			}

		}

		for (int i = 1; i <= n; i++) {
			parent[i] = find(i);
			if (parent[i] == 0) {
				parties.removeAll(arr[i]);
			}
		}
		System.out.println(parties.size());

	}// main

	// 합치기
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootB < rootA) {
				parent[rootA] = rootB;
			} else {
				parent[rootB] = rootA;
			}
		}

	}

	// 루트노드 찾기
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}
