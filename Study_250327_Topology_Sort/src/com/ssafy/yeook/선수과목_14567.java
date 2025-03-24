package com.ssafy.yeook;

	import java.util.*;
	import java.io.*;

	public class 선수과목_14567 {
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int [] indegree = new int[n+1];
	        List<Integer> [] adjs = new ArrayList[n+1];
	        int [] result = new int[n+1];

	        for(int i = 1;i<=n;i++){
	            adjs[i] = new ArrayList<Integer>();
	        }
	        for(int i = 0;i<m;i++){
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            indegree[b]++;
	            adjs[a].add(b);
	        }
	        
	        int count = 1;
	        Set<Integer> visit = new HashSet<>();
	        Queue<Integer> queue = new LinkedList<>();
	        for(int i =1;i<=n;i++){
	            if(indegree[i]==0){
	                queue.add(i);
	                visit.add(i);
	            }
	        }//진입차수 0인것 추가.
	        
	        while(!queue.isEmpty()){
	        	int size = queue.size();
	            for(int i = 0;i<size;i++){
	                 int deque = queue.poll();
	                 result[deque] = count;
	                 for(int adj:adjs[deque]){
	                     if(!visit.contains(adj)){
	                         indegree[adj]--;
	                         if(indegree[adj]==0){
	                              queue.add(adj);
	                              visit.add(adj);
	                         }
	                      }
	                  }
	            }
	            count++;
	        }//queue while
	        StringBuilder results = new StringBuilder();
	        
	        for(int i = 1;i<=n;i++){
	            results.append(result[i]).append(" ");
	        }
	        System.out.print(results.toString().trim());
	        
	        
	    }//main
	}