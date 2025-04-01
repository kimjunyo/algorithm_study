package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1414_불우이웃돕기 {
	static int[] set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		set = new int[N];
		for (int i = 0; i < N; i++) {
			set[i] = i;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		String str;
		int length;
		for(int i = 0 ; i < N ; i++) {
			str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				length = str.charAt(j);
				if(length == '0') {
					continue;
				}else if(length <= 90) {
					length = length - 'A' + 27;
				}else {
					length = length - 'a' + 1;
				}
				pq.add(new int[] {i, j, length});
			}
		}
		
		int[] temp;
		int com1;
		int com2;
		int sum = 0;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			com1 = temp[0];
			com2 = temp[1];
			length = temp[2];
			
			if(findSet(com1) != findSet(com2)) {
				unionSet(com1, com2);
			}else {
				sum += length;
			}
		}
		
		for(int i = 0 ; i < N - 1 ; i++) {
			if(findSet(i) != findSet(i + 1)){
				sum = -1;
				break;
			}
		}
		
		System.out.println(sum);
	}
	
	public static int findSet(int i) {
		if(set[i] == i) {
			return i;
		}
		return set[i] = findSet(set[i]);
	}
	
	public static void unionSet(int i, int j) {
		i = findSet(i);
		j = findSet(j);
		
		if(i < j) {
			set[j] = i;
		}else {
			set[i] = j;
		}
	}
	
}
