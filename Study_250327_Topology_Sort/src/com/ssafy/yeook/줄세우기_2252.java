package com.ssafy.yeook;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Queue;
	import java.util.StringTokenizer;
	public class 줄세우기_2252 {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] indegree = new int[n + 1]; // 진입차수 저장
			boolean[] visit = new boolean[n + 1]; // 방문여부 저장
			List<Integer>[] adjs = new LinkedList[n + 1]; // 인접정점저장
			visit[0] = true;
			for (int i = 1; i <= n; i++) {
				adjs[i] = new LinkedList<Integer>();
			}
			// 주어진 인접 정점 저장. a->b
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjs[a].add(b);
				indegree[b]++;
			}

			Queue<Integer> needtovisit = new LinkedList<>();
			// 진입차수가 0인것들 저장.
			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0) {
					needtovisit.add(i);
					visit[i] = true;
				}
			}
			StringBuilder result = new StringBuilder();// 결과 저장.

			while (!needtovisit.isEmpty()) {
				int deque = needtovisit.poll();
				result.append(deque).append(" ");

				// 진입차수가 0인 정점의 인접 정점들을 순회하며 진입차수를 -1해주고 0이라면 큐에 저장.
				for (int adj : adjs[deque]) {
					if (!visit[adj]) {
						indegree[adj]--; // 진입차수 감소
						if (indegree[adj] == 0) { // 진입차수 0이면 큐에 저장.
							visit[adj] = true; // 방문처리
							needtovisit.add(adj);
						}
					}
					/*
					 * else { break;//-> 사이클인경우. }
					 */
				}
			} // while

			System.out.print(result.toString().trim());

		}

	}
