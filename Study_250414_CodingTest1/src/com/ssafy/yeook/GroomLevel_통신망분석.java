package com.ssafy.yeook;

import java.io.*;
import java.util.*;

class 통신망분석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer>[] adjs = new ArrayList[n+1];
		for(int i = 1;i<=n;i++){
			adjs[i] = new ArrayList<Integer>();
		}

		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjs[a].add(b);
			adjs[b].add(a);
		}//인접 정점 저장.

		boolean [] resultComputer = new boolean[n+1];
		double density = 0;
		int ComputerCount = Integer.MAX_VALUE;
		int minComputerNum = Integer.MAX_VALUE;
		
		boolean [] isContained = new boolean[n+1];
		for(int i = 1;i<=n;i++){
			if(!isContained[i]){
				boolean[] visit = new boolean[n+1];
				Queue<Integer> needtovisit = new ArrayDeque<>();
				int count = 1;
				needtovisit.add(i);
				visit[i]=true;
				isContained[i] = true;
				
				double edgeCount = 0;
				while(!needtovisit.isEmpty()){
					int deque = needtovisit.poll();
					for(int adj:adjs[deque]){
						edgeCount++;
						if(!visit[adj]){
							visit[adj]=true;
							needtovisit.add(adj);
							isContained[adj] = true;
							count++;
						}
					}
				}//bfs
				
				double curdensity = (edgeCount/2)/count;
				if(curdensity>density
					 ||(curdensity==density&&ComputerCount>count)
					 ||(curdensity==density&&ComputerCount==count&&minComputerNum>i)
					){
					resultComputer = visit;
					density = curdensity;
					ComputerCount =count;
					minComputerNum = i;
				}



				
			}
		}//전체 순회
		StringBuilder answer = new StringBuilder();
		for(int i = 1;i<=n;i++){
			if(resultComputer[i]){
				answer.append(i).append(" ");
			}
		}

		System.out.println(answer.toString().trim());
	}
}