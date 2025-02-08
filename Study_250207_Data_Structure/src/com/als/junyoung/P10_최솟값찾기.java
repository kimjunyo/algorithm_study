package com.als.junyoung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10_최솟값찾기 {
	static Deque<Node> minDeque = new LinkedList<P10_최솟값찾기.Node>(); // 참고한 부분

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!minDeque.isEmpty() && minDeque.getLast().number > now) {
				minDeque.removeLast();
			}
			
			minDeque.addLast(new Node(i, now));
			if(minDeque.getFirst().index == i-L) {
				minDeque.removeFirst();
			}
			
			bw.write(minDeque.getFirst().number+" ");

//			if (minDeque.isEmpty()) {
//				minDeque.addFirst(new Node(i, num));
//			} else if (minDeque.getFirst().equals(minDeque.getLast())) {
//				if (minDeque.getFirst().number > num) {
//					minDeque.addFirst(new Node(i, num));
//				} else {
//					minDeque.addLast(new Node(i, num));
//				}
//			} else {
//				if (minDeque.getFirst().number > num && minDeque.getLast().number > num ) {
//					i-L
//					minDeque.removeFirst();
//					minDeque.addFirst(new Node(i, num));
//				} else {
//					
//				}
//			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static class Node { // 참고한 부분
		int index;
		int number;

		public Node(int index, int number) {
			this.index = index;
			this.number = number;
		}
	}
}
