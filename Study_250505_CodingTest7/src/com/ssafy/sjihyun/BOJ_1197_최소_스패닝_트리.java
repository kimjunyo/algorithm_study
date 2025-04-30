import java.io.*;
import java.util.*;

public class Main {
	
	static int[] node;
	
	static class Edge{
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static boolean unionFind(int num1, int num2) {
		int root1 = findNode(num1);
		int root2 = findNode(num2);
		
		if(root1==root2) return false;
		if(root1<root2) node[root2] = root1;
		else node[root1] = root2;
		return true; //사이클 아님
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		node = new int[V+1];
		Arrays.setAll(node, i->i);
		
		List<Edge> edges = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, cost));
		}
		
        edges.sort((e1, e2) -> e1.cost - e2.cost);
		
		int totalWeight = 0;
		int cnt = 0;
		for(Edge edge : edges) {
			if(unionFind(edge.from, edge.to)) {
				totalWeight += edge.cost;
				cnt++;
				if(cnt == V-1) break;
			}
		}
		System.out.println(totalWeight);
	}
}
