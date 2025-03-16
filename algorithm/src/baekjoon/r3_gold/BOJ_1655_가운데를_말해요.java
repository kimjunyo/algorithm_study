package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를_말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> d1 = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
		PriorityQueue<Integer> d2 = new PriorityQueue<>(); //오름차순
		
		int N = Integer.parseInt(br.readLine());
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		sb.append(n1+"\n");
		if(n1>n2) {
			sb.append(n2+"\n");
			d2.offer(n1);
			d1.offer(n2);
		}else {
			sb.append(n1+"\n");
			d2.offer(n2);
			d1.offer(n1);
		}
		
		for(int i=2; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp>=d2.peek()) d2.offer(tmp);
			else d1.offer(tmp);
			
			if (d1.size() > d2.size() + 1) {
                d2.offer(d1.poll());
            } else if (d2.size() > d1.size()) {
                d1.offer(d2.poll());
            }
			
			if(i%2==0) {
				int mid = d1.size() > d2.size() ? d1.peek() : d2.peek();
				sb.append(mid+"\n");
			}else {
				int mid = d1.peek() < d2.peek() ? d1.peek() : d2.peek();
				sb.append(mid+"\n");
			}
		}
		System.out.println(sb);
	}
}
