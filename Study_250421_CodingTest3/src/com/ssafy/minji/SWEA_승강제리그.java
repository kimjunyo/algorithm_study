package com.ssafy.minji;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class UserSolution {
	static PriorityQueue<Integer>[] league;
	static int[] mAbility;
	static int n;
	static int L;
	static int mid;

	void init(int N, int L, int mAbility[]) {
		league = new PriorityQueue[L];
		this.mAbility = mAbility; 
		this.L = L;
		n = N / L;
		mid = (n + 1) / 2;
		int idx = 1;
		for (int i = 0; i < L; i++) {
			league[i] = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return mAbility[o1] - mAbility[o2];
				}
			});
			
			for (int j = 0; j < n; j++) {
				league[i].add(idx);
			}
		}
	}

	int move() {
//		int lowLeagueMax = league[0].(n - 1);
		int highLeagueMin;

		return 0;
	}

	int trade() {
		return 0;
	}

}