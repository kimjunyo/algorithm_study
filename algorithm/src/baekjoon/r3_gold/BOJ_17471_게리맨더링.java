package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	
	static List<Integer>[] graph;
	static int N;
	static int[] people;
	static Deque<Integer> deque;
	static boolean[] nodeVisit;
	
	static int[] num;
	static int[] arr;
	static List<List<List<Integer>>> combination;
	
	private static boolean isConnected(List<Integer> area) {
		
		if(area.isEmpty()) return false;
		nodeVisit = new boolean[N+1];
		
		deque = new ArrayDeque<>();
		deque.offer(area.get(0));
		nodeVisit[area.get(0)]= true;
		
		int count = 1;
		while(!deque.isEmpty()) {
			int point = deque.poll();
			
			for(int next : graph[point]) {
				if(!nodeVisit[next] && area.contains(next)) {
					nodeVisit[next] = true;
					deque.offer(next);
					count++;
				}
			}
		}
		return count == area.size();
	}
	
	
	private static void findCombination(int depth, int last, int cnt) {
		if(depth == cnt) {
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();
			
			for(int i=0; i<cnt; i++) {
				group1.add(num[i]);
			}
			for(int i=0; i< N; i++) {
				if(!group1.contains(arr[i])) {
					group2.add(arr[i]);
				}
			}
			
			combination.add(Arrays.asList(group1,group2));
			
			System.out.println(combination);
			return;
		}

		
		for(int i=last+1; i<N; i++) {
			num[depth] = arr[i];
			findCombination(depth+1, i, cnt);
		}
	}
	
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList[N+1];
		nodeVisit = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph[i].add(v);
			}
		}
		
		/*
		for(int i=0; i<nodeList.length; i++) {
			Collections.sort(nodeList[i]);
		}
		*/
		
		//System.out.println(Arrays.toString(graph));
		
		//N을 2개로 나눌 조합을 먼저 생각해야함
		//1/5 2/4/ 3/3 1,2,3이라고 하면
		
		//1.5인 경우 먼저 보자
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		int finalMin = 10001;
		for(int c =1; c <=N/2; c++) {
			num = new int[c];
			combination = new ArrayList<>();
			findCombination(0,-1,c); //5개 조합 찾기
			
			/*
			for(int i=0; i<combination.size(); i++) {
				System.out.println(combination.get(i));
			}
			*/
		
			
			int min = 10001;
			for (List<List<Integer>> comb : combination) {
			    List<Integer> group1 = comb.get(0); // 왼쪽 그룹
			    List<Integer> group2 = comb.get(1); // 오른쪽 그룹
			    
			    if (isConnected(group1) && isConnected(group2)) {
			    	int sum1 = 0;
			    	int sum2 = 0;
			    	for(int idx : group1) {
			    		sum1+= people[idx];
			    	}
			    	for(int idx : group2) {
			    		sum2 += people[idx];
			    	}
			    	
			    	min = Math.min(Math.abs(sum1-sum2), min);
			    }
			}
			//System.out.println("최소 인구 차이: " + (min == 10001 ? -1 : min));
			finalMin = Math.min(min,finalMin);
		}
		//System.out.println("최종 최소 인구 차이: " + (finalMin == 10001 ? -1 : finalMin));
		System.out.println(finalMin == 10001 ? -1 : finalMin);
	}

}
