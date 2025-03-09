package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1707_이분그래프_실패 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine().trim());
		
		nextCase:
		for(int tc = 1 ; tc <= K ; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			Map<Integer, Integer> group = new HashMap<>();
			int v1;
			int v2;
			for(int e = 0 ; e < E ; e++) {
				st = new StringTokenizer(br.readLine());
				v1 = Integer.parseInt(st.nextToken());
				v2 = Integer.parseInt(st.nextToken());
				
				// v1이 0이 아님
				if(group.containsKey(v1)) {
					
					// 서로 인접한 v1과 v2가 둘다 1 또는 -1 : 이분그래프 아님
					if (group.containsKey(v2) && group.get(v1) == group.get(v2)) {
						System.out.println("NO");
						continue nextCase;
					// v2는 v1과 다른 그룹으로 저장	
					}else if(!group.containsKey(v2)) {
						group.put(v2, group.get(v1) * -1);
					}
				// v1이 0임	
				}else {
					// v1 v2 둘다 0이 아님 : 임의로 서로 다른 그룹에 저장
					if(!group.containsKey(v2)) {
						group.put(v1, 1);
						group.put(v2, -1);
					// v1은 v2와 다른 그룹으로 저장	
					}else {
						group.put(v1, group.get(v2) * -1);
					}
				}
			}
			System.out.println("YES");
		}
	}
}