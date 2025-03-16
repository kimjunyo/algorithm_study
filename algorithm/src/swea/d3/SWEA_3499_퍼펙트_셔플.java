package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트_셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Deque<String> deque1 = new ArrayDeque<>();
		Deque<String> deque2 = new ArrayDeque<>();
		
		for(int tc = 1; tc<= T ; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=(N+1)/2; i++) {
				deque1.offerLast(st.nextToken());
			}
			
			for(int i=(N+1)/2+1; i<=N; i++) {
				deque2.offerLast(st.nextToken());
			}
			
			System.out.print("#" + tc + " ");
			for(int i=1; i<=N; i++) {
				if(!deque1.isEmpty()) System.out.print(deque1.pollFirst()+" ");
				if(!deque2.isEmpty())  System.out.print(deque2.pollFirst()+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//
}
