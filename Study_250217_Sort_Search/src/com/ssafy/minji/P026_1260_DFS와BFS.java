package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P026_1260_DFS와BFS {

	static StringBuilder sb;
	static List<Integer>[] nodesPerNode;
	static boolean[] checkArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		nodesPerNode = new ArrayList[N + 1];
		checkArr = new boolean[N + 1];

		int temp1;
		int temp2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			if (nodesPerNode[temp1] == null) {
				nodesPerNode[temp1] = new ArrayList<Integer>();
			}
			nodesPerNode[temp1].add(temp2);
			
			if (nodesPerNode[temp2] == null) {
				nodesPerNode[temp2] = new ArrayList<Integer>();
			}
			nodesPerNode[temp2].add(temp1);
		}
		
		for (int i = 0; i < N + 1; i++) {
			if (nodesPerNode[i] != null)
				Collections.sort(nodesPerNode[i]);
		}

		sb = new StringBuilder();
		DFS(V);
		System.out.println(sb);

		sb.setLength(0);
		for (int i = 0; i < checkArr.length; i++) {
			checkArr[i] = false;
		}
		Queue<Integer> nodesQue = new LinkedList<>();

		nodesQue.add(V);
		checkArr[V] = true;
		BFS(nodesQue);

	}

	static void DFS(int searchNode) {
		checkArr[searchNode] = true;
		sb.append(searchNode + " ");

		if (nodesPerNode[searchNode] == null)
			return;
		
		for (int n : nodesPerNode[searchNode]) {
			if (checkArr[n] == false) {
				DFS(n);
			}
		}
	}

	static void BFS(Queue<Integer> nodesQue) {
		if (nodesQue.isEmpty()) {
			System.out.println(sb);
			return;
		}
		
		int node = nodesQue.poll();
		sb.append(node + " ");

		if (nodesPerNode[node] != null) {
			for (int n : nodesPerNode[node]) {
				if (checkArr[n] == false) {
					checkArr[n] = true;
					nodesQue.add(n);
				}
			}
		}
		BFS(nodesQue);
	}

}
