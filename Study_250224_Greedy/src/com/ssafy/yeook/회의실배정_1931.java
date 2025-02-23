package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{if(a[1]==b[1]) {return a[0]-b[0];}return a[1]-b[1];});
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			heap.add(new int[] {s,e});
		}
		int total = 1;
		int num = heap.poll()[1];
		while (heap.size() > 0) {
			int [] se = heap.poll();
			if(se[0]>=num) {
				total++;
				num=se[1];
			}
		}
		System.out.println(total);
	}
}
