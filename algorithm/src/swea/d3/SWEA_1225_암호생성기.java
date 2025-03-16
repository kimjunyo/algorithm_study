package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Deque<Integer> deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=8; i++) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			}
			
			int num =1;
			while(true) {
				if(num==6) num =1;
				int point = deque.pollFirst() - num++;
				if(point <=0) {
					point = 0;
					deque.offerLast(point);
					break;
				} else deque.offerLast(point);	
			}		
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst()).append(" ");
			}
			System.out.println(sb);
		}
	}
}
