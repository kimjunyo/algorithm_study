package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터_큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<N; i++) {
				int input = Integer.parseInt(st.nextToken());
				if(i==M) q.add(-input); //target 구분하기 위해 -1로 넣어줌
				else q.add(input);
				pq.add(input);
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				if(q.peek() == -pq.peek()) {
					cnt++;
					break;
				}
				
				if(q.peek() == pq.peek()) {
					pq.poll();
					q.poll();
					cnt++;
				}else {
					q.offer(q.poll());
				}
			}
			
			System.out.println(cnt);
			q.clear();
			pq.clear();
		}
	}
}
