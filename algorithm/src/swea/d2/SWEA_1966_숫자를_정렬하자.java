package swea.d2;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//삽입정렬
public class SWEA_1966_숫자를_정렬하자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> ll = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				ll.add(Integer.parseInt(st.nextToken()));				
			}
			
			for(int i=1; i<ll.size(); i++) { //1부터 해줘야함
				int key = ll.get(i);
				int j = i-1;
				while(j>=0 && ll.get(j) > key) {
					ll.set(j+1, ll.get(j));
					j--;
				}
				ll.set(j+1, key);
			}

			sb.append("#" + tc + " ");
			for(int v : ll) {
				sb.append(v+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}