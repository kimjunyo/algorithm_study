package com.ssafy.minji;

import java.io.*;
import java.util.*;

class GTM_195699 {
	static int[][] comp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// {그룹번호, 컴퓨터 수, 간선 수}
		comp = new int[N + 1][3];
		for(int i = 1 ; i <= N ; i++){
			comp[i][0] = i;
			comp[i][1] = 1;
		}

		int minComponent = Integer.MAX_VALUE;
		int minCom = Integer.MAX_VALUE;
		int minLine = Integer.MAX_VALUE;
		int com1, com2, temp;
		
		for(int i = 0 ; i < M ; i++){
			st = new StringTokenizer(br.readLine());
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			if(com1 > com2){
				temp = com1;
				com1 = com2;
				com2 = temp;
			}

			// 컴퓨터, 간선 개수 추가
			comp[com1][1]++;
			comp[com2][1]++;
			comp[com1][2]++;
			comp[com2][2]++;

			merge(com1, com2);
			int groupNum = getGroup(com1);
			if(minComponent > groupNum){
				minComponent = groupNum;
				minCom = comp[groupNum][1];
				minLine = comp[groupNum][2];
				
			}else if(minComponent == groupNum){
				
				if(minCom > comp[groupNum][1]){
					minComponent = groupNum;
					minCom = comp[groupNum][1];
					minLine = comp[groupNum][2];
					
				}else if(minCom == comp[groupNum][1]){
					if(minLine > comp[groupNum][2]){
						minComponent = groupNum;
						minCom = comp[groupNum][1];
						minLine = comp[groupNum][2];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N ; i++){
			if(getGroup(i) == minComponent){
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}

	public static void merge(int com1, int com2){
		int minGroupNum = getGroup(com1);
		
		// 간선 개수 추가
		comp[minGroupNum][2] += comp[com2][2];

		// 현재 같은 그룹이 아닐 경우
		if(minGroupNum != getGroup(com2)){
			// 컴퓨터도 추가
			comp[minGroupNum][1] += comp[com2][1];
		}
	}

	public static int getGroup(int com1){
		int group = comp[com1][0];
		if(group == com1){
			return com1;
		}
		return group = getGroup(group);
	}
	
	
}