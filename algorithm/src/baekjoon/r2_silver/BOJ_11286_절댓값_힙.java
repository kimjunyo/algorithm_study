package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1= Math.abs(o1);
				int abs2= Math.abs(o2);
				
				if(abs1==abs2) 
					return o1-o2;
				
				return abs1-abs2;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input ==0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(input);
			}
		}
		System.out.println(sb);
	}
}
