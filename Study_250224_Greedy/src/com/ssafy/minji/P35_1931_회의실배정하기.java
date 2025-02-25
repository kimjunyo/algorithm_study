package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P35_1931_회의실배정하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int[] start = new int[N];
		int[] end = new int[N];
		int maxStart = 0;
		int maxEnd = 0;
		int MinEndStart = 0; 
		int minEnd = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++	) {
			st = new StringTokenizer(br.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
			if(maxStart < start[i]) {
				maxStart = start[i];
			}
			if(maxEnd < end[i]) {
				maxEnd = end[i];
			}
			if(minEnd < end[i]) {
				minEnd = end[i];
				MinEndStart = start[i];
			}
		}
		// 끝나는 시간 기준으로 리스트
		PriorityQueue<Integer>[] pqArr = new PriorityQueue[maxEnd + 1];
		for(int i = 0 ; i < maxEnd + 1 ; i++) {
			pqArr[i] = new PriorityQueue<Integer>();
		}
		for(int i = 0 ; i < N ; i++) {
			pqArr[end[i]].add(start[i]);
		}
		
		int now = maxEnd;
		while(now <= maxStart) {
//			pqArr[now] = 
		}
		
		
		
	}
}
