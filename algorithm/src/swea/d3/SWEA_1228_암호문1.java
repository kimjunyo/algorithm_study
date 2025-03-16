package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> linklist = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				linklist.add(Integer.parseInt(st.nextToken()));
				
			}
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int t = 1; t<=T; t++) {
				String check = st.nextToken();
				int spot = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for(int i=1; i<=num; i++) {
					linklist.add(spot++, Integer.parseInt(st.nextToken()));
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("# ").append(tc).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(linklist.get(i)).append(" ");
			}
			System.out.println(sb);
		}
	}
}
