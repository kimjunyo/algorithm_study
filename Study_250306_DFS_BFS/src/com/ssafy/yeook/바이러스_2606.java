package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class 바이러스_2606 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		LinkedList<Integer>[]arr = new LinkedList[n+1];
		for(int i = 1;i<=n;i++) {
			arr[i] = new LinkedList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
	
			arr[a].add(b);
			arr[b].add(a);
		}//주어진 엣지 저장.
		
		Set<Integer> visit = new HashSet<>();
		Queue<Integer> needtovisit = new LinkedList<>();
		
		visit.add(1);
		needtovisit.add(1);
		while(!needtovisit.isEmpty()) {
			int deque = needtovisit.poll();
			for(int i :arr[deque]) {
				if(!visit.contains(i)) {
					visit.add(i);
					needtovisit.add(i);
				}
			}
		}
	System.out.println(visit.size()-1);
		
		
	}
	
	
}
