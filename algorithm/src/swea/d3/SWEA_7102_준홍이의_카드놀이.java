package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_7102_준홍이의_카드놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] cnt = new int[N+M+1];
			Deque<Integer> dequeN = new ArrayDeque<>();
			Deque<Integer> dequeM = new ArrayDeque<>();
			
			for(int i=1; i<=N;i++) {
				dequeN.offerLast(i);
			}
			
			for(int i=1; i<=M;i++) {
				dequeM.offerLast(i);
			}
			
			while(!dequeN.isEmpty()) {
				int card1 = dequeN.pollFirst();
				for(int i=1; i<=M; i++) {
					int card2 = dequeM.pollFirst();
					cnt[card1+card2]++;
					dequeM.offerLast(card2);
				}
			}
			
			int max = 0;
			for(int v : cnt) {
				max = Math.max(max,v);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			for(int i=1; i<cnt.length; i++) {
				if(cnt[i] == max) {
					sb.append(i).append(" ");
				}
			}
		System.out.println(sb);	
		}
	}
}