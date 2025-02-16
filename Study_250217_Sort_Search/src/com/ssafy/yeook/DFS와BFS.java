package 알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class DFS와BFS {
	// map의 {key,value} = {정점 :현재 정점에 연결된 이웃 정점들저장. }
	public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	// 방문할 정점을 저장.
	public static Set<Integer> visitSet = new HashSet<>();
	// DFS의 결과를 저장.
	public static StringBuilder resultDFS = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder resultBFS = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // 정점의 갯수
		int m = Integer.parseInt(st.nextToken()); // 간선의 갯수
		int v = Integer.parseInt(st.nextToken()); // 출발할 정점.
		// map에 저장된 키들을 저장.
		List<Integer> keys = new ArrayList<>();
		Set<Integer> keyset = new HashSet<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!map.containsKey(a)) {
				map.put(a, new ArrayList<Integer>());
			}
			if (!map.containsKey(b)) {
				map.put(b, new ArrayList<Integer>());
			}
			if (!keyset.contains(a)) {
				keyset.add(a);
				keys.add(a);
			}
			;
			if (!keyset.contains(b)) {
				keyset.add(b);
				keys.add(b);
			}
			;
			map.get(a).add(b);
			map.get(b).add(a);

		}

		// map에 저장된 값(리스트)을 오름차순으로 저장.
		// 출력할때 오름차순으로 출력해야하므로 정렬함.
		for (int elm : keys) {
			map.get(elm).sort((aa, bb) -> {
				if (aa > bb)
					return 1;
				else if (aa == bb) {
					return 0;
				} else {
					return -1;
				}
			});
		}
		// DFS : 재귀함수호출
		resultDFS.append(v).append(" ");
		visitSet.add(v);
		dfs(v);

		// BFS
		Set<Integer> needtovisitSet = new HashSet<>(); // 방문할 정점을 추가할 때, 중복추가 안하려고 방문할 정점을 저장한 set도 만듦
		visitSet.clear();

		// 방문할 정점.
		Queue<Integer> needtoQueue = new LinkedList<>();
		needtoQueue.add(v);

		// 방문할 정점이 없을때까지 반복.
		while (!needtoQueue.isEmpty()) {
			// 현재 방문한 정점
			int num = needtoQueue.poll();
			// 방문했음을 표시.
			visitSet.add(num);
			resultBFS.append(num).append(" "); // 결과에 추가.
			// 해당 키가 맵에 있으면 시행. 없으면 연결된 정점이 없음을 의미.
			if (map.containsKey(num)) {

				// 현재 방문한 정점의 인접한 정점들을 순회하며 방문하지 않은경우 앞으로 방문해야하는 큐에 저장.
				for (int elm : map.get(num)) {
					if (!visitSet.contains(elm) && !needtovisitSet.contains(elm)) {
						needtovisitSet.add(elm);
						needtoQueue.add(elm);
					}

				}
			}
		}

		// 결과 출력.
		System.out.println(resultDFS.toString().trim());
		System.out.println(resultBFS.toString().trim());
	}

	//
	public static void dfs(int num) {
		if (map.containsKey(num)) {
			for (int elm : map.get(num)) {
				if (!visitSet.contains(elm)) {
					visitSet.add(elm);
					resultDFS.append(elm).append(" ");
					dfs(elm);
				}
			}
		}

	}

}
/*
 * 예제1. map {1:2,3,4} {2:4} {3:4} {4:1,2,3}
 *
 *
 *
 * dfs 1) dfs(1) : visit{1} result : 1 2) -> 1에 연결된 정점 차례로 방문 <2,3,4>중 dfs(2)먼저
 * 시행. 3) -> dfs(2) : visit{1,2} 4) -> 2에 연결된 정점 차례로 방문 <4> 중 dfs(4) 시행. 5) ->
 * dfs(4) : visit{1,2,4} 6) -> 2에 연결된 정점 차례로 방문 <1,2,3> 중 방문안한 정점을 3 뿐이므로 dfs(3)
 * 시행. 7) -> dfs(3) : visit {1,2,4,3} 8) -> 3에 연결된 정점 차례로 방문 <4> 중 방문안한 정점은 없으므로
 * 함수 종료 후 호출한 곳 6)으로 돌아감. 돌아가면 더이상 방문안한 정점 없으므로 함수 종료 후 호출한 곳4)로 돌아감 돌아가면 더이상
 * 방문한 정점 없으므로 함수 종료 후 호출한 곳 2)로 돌아감. 돌아가면 더이상 방문한 정점 없으므로 함수 종료 후 호출한 곳 (맨처음
 * 호출한 곳으로 돌아감.)으로 돌아감.//최종 종료됨.
 * 
 */
