package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2605_줄_세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> ll = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		ll.add(num,1);
		
		for(int i=2; i<=N; i++) {
			int size = ll.size();
			num = Integer.parseInt(st.nextToken());
			ll.add(size-num, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ll.size(); i++) {
			sb.append(ll.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
}
