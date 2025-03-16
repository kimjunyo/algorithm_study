package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1232_사칙연산 {

	static String[] abc;
	static List<Integer>[] graph;
	static int N, result;
	static boolean[] visit;
	static StringBuilder sb;
	static Deque<String> calc;

	private static void postOrder(int num) {
		if (visit[num])
			return;

		visit[num] = true;

		for (int s : graph[num]) {
			if (!visit[s]) {
				postOrder(s);
			}
		}
		calc.offerLast(abc[num]);
	}
	
	// 964-/3*
	private static void calculation() {
		Stack<Integer> operate = new Stack<>();
		
		result = 0;
		while(!calc.isEmpty()) {
			String point = calc.pollFirst();
			if(point.equals("+")){
				int num2 = operate.pop();
				int num1 = operate.pop();
				operate.push(num1 + num2);
			}else if(point.equals("-")){      
				int num2 = operate.pop();
				int num1 = operate.pop();
				operate.push(num1 - num2);
			}else if(point.equals("*")){
				int num2 = operate.pop();
				int num1 = operate.pop();
				operate.push(num1 * num2);
			}else if(point.equals("/")){
				int num2 = operate.pop();
				int num1 = operate.pop();
				operate.push(num1 / num2);
			}else operate.push(Integer.parseInt(point));	
		}
		result = operate.pop();
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());

			abc = new String[N + 1];
			graph = new ArrayList[N + 1];
			visit = new boolean[N + 1];
			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				abc[i + 1] = st.nextToken();
				while (st.hasMoreTokens()) {
					graph[u].add(Integer.parseInt(st.nextToken()));
				}
			}

//			System.out.println(Arrays.toString(graph));
//			System.out.println(Arrays.toString(abc));
			
			
			calc = new ArrayDeque<>();
			sb = new StringBuilder();
			sb.append("#" + tc + " ");

			postOrder(1); // 964-/3*

			//System.out.println(calc);
			
			
			calculation();
			sb.append(result);
			System.out.println(sb);
			//System.out.println(result);
			//calc.pop();
			//System.out.println(calc);
			sb.setLength(0);

		}

	}

}
