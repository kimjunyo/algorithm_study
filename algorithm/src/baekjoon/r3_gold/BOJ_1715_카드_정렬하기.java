package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1715_카드_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		
		int cnt= 0;
		while(q.size() !=1) {
			int A = q.poll();
			int B = q.poll();
			q.offer(A+B);
			cnt += A + B;
			//System.out.println(cnt);
			//System.out.println(q);
		}
		System.out.println(cnt);
	}
}