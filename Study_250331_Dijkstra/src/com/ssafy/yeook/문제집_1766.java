package com.ssafy.yeook;

	import java.util.*;
	import java.io.*;

	public class 문제집_1766 {
	    public static void main(String[]args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        StringBuilder result = new StringBuilder();
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int [] indegree = new int[n+1];
	        List<Integer> [] adjs = new ArrayList[n+1];
	        for(int i = 1;i<=n;i++){
	            adjs[i] = new ArrayList<Integer>();
	        }
	        
	        for(int i=0;i<m;i++){
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            indegree[b]++;
	            adjs[a].add(b);
	        }
	        PriorityQueue<Integer> needtovisit = new PriorityQueue<>(); //숫자가 낮은 순으로 저장.
	        for(int i = 1;i<=n;i++){
	            if(indegree[i]==0){
	                needtovisit.add(i);
	            }
	        }
	        
	        while(!needtovisit.isEmpty()){
	            int deque = needtovisit.poll();
	            result.append(deque).append(" ");
	            
	            for(int adj:adjs[deque]){
	                indegree[adj]--;
	                if(indegree[adj]==0) needtovisit.add(adj);
	            }
	            
	        }//needtovisit while
	        System.out.print(result.toString().trim());
	    }//main
	}