package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//후위순회
public class SWEA_1231_중위순회 {
	
	static String[] abc;
	static List<Integer>[] graph;
	static int N;
	static boolean[] visit;
	static StringBuilder sb;
	

	
	//전위순회
	private static void preOrder(int num) {
	    if (visit[num]) return;  

	    visit[num] = true; 
	    sb.append(abc[num]);

	    for (int s : graph[num]) {  
	        if (!visit[s]) {  
	            preOrder(s);  
	        }
	    }
	}

	//중위순회
	private static void inOrder(int num) {
	    if (visit[num]) return;  

	    visit[num] = true; 
	    if (graph[num].size() != 0) {  
	        inOrder(graph[num].get(0));  
	    }

	    sb.append(abc[num]);

	    if (graph[num].size() ==2) {  
	        inOrder(graph[num].get(1)); 
	    }
	}
	
	
	//후위순회
	private static void postOrder(int num) { 
	    if (visit[num]) return; 

	    visit[num] = true; 

	    for (int s : graph[num]) {  
	        if (!visit[s]) {  
	            postOrder(s); 
	        }
	    }
	    sb.append(abc[num]);
	}	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		for(int tc =1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			
			abc = new String[N+1];
			graph = new ArrayList[N+1]; 
			visit = new boolean[N+1];
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			} //그래프 널 제거
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				abc[i+1] = st.nextToken();
				while(st.hasMoreTokens()) {
					graph[u].add(Integer.parseInt(st.nextToken()));
				}
			} //그래프 초기화
			
//			System.out.println(Arrays.toString(graph)); // 그래프 구성 알 수 있음
//			System.out.println(Arrays.toString(abc));
			
			sb = new StringBuilder();
			sb.append("#"+tc+" ");
			//1번 노드부터 탐색
			//preOrder(1); //WFOSTRAE
			//postOrder(1); //SOTFAERW
			inOrder(1); //SOFTWARE
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
