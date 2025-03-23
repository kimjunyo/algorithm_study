package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1043_거짓말 {
	static int[] person;
	static List<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		person = new int[N + 1];
		party = new ArrayList[M];
		
		for(int i = 0 ; i < N + 1 ; i++) {
			person[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < k ; i++) {
			person[Integer.parseInt(st.nextToken())] = 0;
		}
		
		int attend;
		int temp1;
		int temp2;
		for(int i = 0 ; i < M ; i++) {
			List<Integer> list = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			attend = Integer.parseInt(st.nextToken());
			
			temp2 = Integer.parseInt(st.nextToken());
			list.add(temp2);
			
			for(int j = 1 ; j < attend ; j++) {
				temp1 = temp2;
				temp2 = Integer.parseInt(st.nextToken());
				list.add(temp2);
				root(temp1, temp2);
			}
			party[i] = list;
		}
		
		int partyCnt = 0;
		nextParty: for(List<Integer> list : party) {
			for(int i : list) {
				if(find(i) == 0) {
					continue nextParty;
				}
			}
			partyCnt++;
		}
		System.out.println(partyCnt);
	}
	
	static int find(int x) {
	    if (person[x] != x) {
	    	person[x] = find(person[x]);
	    }
	    return person[x];
	}

	static void root(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);
	    if (rootA < rootB) {
	    	person[rootB] = rootA;
	    }else if(rootB < rootA) {
	    	person[rootA] = rootB;
	    }
	}
}
