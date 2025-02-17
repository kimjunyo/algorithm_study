package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class ABCDE_13023 {
	static Set<Integer> visit = new HashSet<>();
	static Stack<Integer> needtovisit = new Stack<>();
	static int n;
	static int m;
	static boolean isOk = false;
	static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 각 숫자마다 연결된 노드 저장할 리스트 생성.
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		// 주어진 연결된 노드들 저장.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}

		// 터미널 노드들 저장.
		List<Integer> terminals = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (map.get(i).size() == 1) {
				terminals.add(i);
			}
		}

		for (int i = 0; i < n; i++) {
			if (isOk)
				break;
			visit.clear();
			visit.add(i);
			dfs(i, 1);
		}

		if (isOk) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static void dfs(int num, int count) {
		if (count == 5) {
			isOk = true;
			return;
		}

		if (!isOk) {
			for (int elm : map.get(num)) {
				if (!visit.contains(elm)) {
					visit.add(elm);

					dfs(elm, count + 1);
					visit.remove(elm);
				}
			}
		}

	}
}
