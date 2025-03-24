package com.ssafy.junyeong.boj14567_선수과목;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] subjects = new ArrayList[N+1];
		int[] subjectsTopology = new int[N+1];
		int[] res = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			subjects[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			subjects[A].add(B);
			subjectsTopology[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int semester = 1;
		
		for(int i=1; i<=N; i++) {
			if(subjectsTopology[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			for(int i=0; i<n; i++) {
				int input = queue.poll();
				res[input] = semester;
				subjectsTopology[input]--;
				
				for(int j=0; j<subjects[input].size(); j++) {
					int sel = subjects[input].get(j);
					
					subjectsTopology[sel]--;
				}
			}
			semester++;
			
			for(int i=1; i<=N; i++) {
				if(subjectsTopology[i] == 0) {
					queue.offer(i);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(res[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
