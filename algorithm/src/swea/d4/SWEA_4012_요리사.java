
/*
package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int[][] arr;
	static int[] select;
	static int[] num;
	static int N;
	static List<List<Integer>> combination;
	static int minSynergy;

	private static void findCombination(int depth, int last, int cnt) {
		if (depth == cnt) {
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();
			for (int i = 0; i < cnt; i++) {
				group1.add(num[i]);
			}
			
			Set<Integer> group1Set = new HashSet<>(group1);
			for (int i = 0; i < N; i++) {
				if (!group1Set.contains(select[i])) {
					group2.add(select[i]);
				}
			}
			combination = new ArrayList<>();
			combination.addAll(Arrays.asList(group1, group2));
			
			//System.out.println(combination);
			calculate(combination);
			return;
		}

		for (int i = last + 1; i < N; i++) {
			num[depth] = select[i];
			findCombination(depth + 1, i, cnt);
		}
	}
	
	private static void calculate(List<List<Integer>> combination) {
		int synergy1 =0;
		int synergy2 =0;
		List<Integer> group1 = combination.get(0);
		List<Integer> group2 = combination.get(1);
		
		for(int n : group1) {
			for(int m : group1) {
				synergy1 += arr[n][m];
			}
		}
		
		for(int n : group2) {
			for(int m : group2) {
				synergy2 += arr[n][m];
			}
		}
		minSynergy = Math.min(Math.abs(synergy1-synergy2), minSynergy);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());

			arr = new int[N+1][N+1];
			num = new int[N / 2];
			select = new int[N];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 받고

			for (int i = 0; i < N; i++) {
				select[i] = i + 1;
			}
			
			minSynergy= Integer.MAX_VALUE;
			findCombination(0, -1, N / 2);
			System.out.println(sb.append(minSynergy));
			sb.setLength(0);
		}
	}
}
*/
package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int[][] arr;
	static int[] num;
	static int N;
	static int minSynergy;

	private static void findCombination(int depth, int last, int cnt) {
		if (depth == cnt) {
			calculate();
			return;
		}

		for (int i = last + 1; i < N; i++) {
			num[depth] = i; 
			findCombination(depth + 1, i, cnt);
		}
	}

	private static void calculate() {
		boolean[] isSelected = new boolean[N];
		for (int idx : num) {
			isSelected[idx] = true;
		}

		int synergy1 = 0, synergy2 = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (isSelected[i] && isSelected[j]) {
					synergy1 += arr[i][j] + arr[j][i]; // 그룹1 시너지
				} else if (!isSelected[i] && !isSelected[j]) {
					synergy2 += arr[i][j] + arr[j][i]; // 그룹2 시너지
				}
			}
		}
		minSynergy = Math.min(Math.abs(synergy1 - synergy2), minSynergy);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			num = new int[N / 2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minSynergy = Integer.MAX_VALUE;
			findCombination(0, -1, N / 2);
			sb.append(minSynergy).append("\n");
		}
		System.out.print(sb);
	}
}

