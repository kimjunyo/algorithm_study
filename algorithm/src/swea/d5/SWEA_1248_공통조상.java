package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//깊이를 맞추고 탐색하는 방법도 알아보기

public class SWEA_1248_공통조상 {

	static int[] parent; //리스트배열까지 필요 없음
	static List<Integer>[] children;
	static Set<Integer> findCommon;
	static Queue<Integer> queue;
	static StringBuilder sb;

	
	private static void findAncestor(int target1, int target2) {
		findCommon = new HashSet<>();
		int node = target1;
		while(node != 1) {
			findCommon.add(node);
			node = parent[node];
		}
		findCommon.add(1);
		
		node = target2;
		while(!findCommon.contains(node)) {
			node = parent[node];
		}
		sb.append(node+" ");
		findChildren(node);
		
	}
	
	private static void findChildren(int ancestor) {
		queue = new ArrayDeque<>();
		queue.offer(ancestor);
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int point = queue.poll();
			for(int v : children[point]) {
				cnt++;
				queue.add(v);
			}
		}
		sb.append(cnt);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			// V E 정점1 정점2
			st = new StringTokenizer(br.readLine()); // 13 12 8 13
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());

			parent = new int[V + 1];
			children = new List[V + 1];
			
			for (int i = 0; i < V + 1; i++) {
				children[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				parent[v] = u;
				children[u].add(v);
			}

			
			sb.append("#" + tc + " ");
			findAncestor(target1, target2);
			//System.out.println(Arrays.toString(parent));
			//System.out.println(Arrays.toString(children));
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
