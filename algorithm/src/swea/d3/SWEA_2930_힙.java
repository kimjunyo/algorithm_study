package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


/*배열로 구현
public class SWEA_2930_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			int N = Integer.parseInt(br.readLine());
			int[] heap = new int[N+1];
			int idx = 0;
			
			for(int i=1; i<= N ; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("1")) {
					heap[++idx] = Integer.parseInt(st.nextToken());
					int p = idx;
					while(p>=2 && heap[p]>heap[p/2]) {
						int tmp = heap[p];
						heap[p] = heap[p/2];
						heap[p/2] = tmp;
						p /=2;
					}
				}else {
					if(idx == 0) sb.append("-1 ");
					else {
						sb.append(heap[1]+" ");
						heap[1] = heap[idx];
						heap[idx--] = 0;
						int p =1;		
						while(p*2 <=idx) {
							int check = (p * 2 + 1 <= idx && heap[p * 2 + 1] > heap[p * 2]) ? p * 2 + 1 : p * 2;
							if (heap[p] >= heap[check]) break;
							
							int tmp = heap[p];
				            heap[p] = heap[check];
				            heap[check] = tmp;
				            p = check;
						}
					}
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}//
	}
}
*/

public class SWEA_2930_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
//			Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); //
			Queue<Integer> q = new PriorityQueue<>((a,b) -> b-a); //람다식
//			Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() { //comparator
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2-o1;
//				}
//			});
			
			sb.append("#"+tc+" ");
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i=1; i<= N ; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("1")) {
					q.add(Integer.parseInt(st.nextToken()));
				}else {
					if(q.isEmpty()) sb.append(-1+" ");
					else {
						sb.append(q.poll() + " ");
					}
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}