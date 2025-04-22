package com.ssafy.minji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UserSolution {
	class Team {
		List<Player> players;
		Player maxP;
		Player midP;
		Player minP;
	}

	class Player {
		int number;
		int ability;
	}

	static Team[] league;
	static int n;
	static int L;
	static int mid;

	void init(int N, int L, int mAbility[]) {
		league = new Team[L];
		this.L = L;
		n = N / L;
		mid = n / 2;
		int idx = 0;
		for (int i = 0; i < L; i++) {
			league[i] = new Team();
			league[i].players = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				Player p = new Player();
				p.number = idx;
				p.ability = mAbility[idx++];
				league[i].players.add(p);
			}
			sortAndSetTradable(i);
		}
	}

	int move() {
		int sum = 0;

		for (int i = 0; i <= L - 2; i++) {
			sum += league[i].minP.number;
			sum += league[i + 1].maxP.number;
			league[i].players.remove(league[i].minP);
			league[i].players.add(league[i + 1].maxP);
			league[i + 1].players.remove(league[i + 1].maxP);
			league[i + 1].players.add(league[i].minP);
		}

		for (int i = 0; i < L ; i++) {
			sortAndSetTradable(i);
		}
		
		return sum;
	}

	int trade() {
		int sum = 0;

		for (int i = 0; i <= L - 2; i++) {
			sum += league[i].midP.number;
			sum += league[i + 1].maxP.number;
			league[i].players.remove(league[i].midP);
			league[i].players.add(league[i + 1].maxP);
			league[i + 1].players.remove(league[i + 1].maxP);
			league[i + 1].players.add(league[i].midP);
		}

		for (int i = 0; i < L ; i++) {
			sortAndSetTradable(i);
		}
		
		return sum;
	}

	void sortAndSetTradable(int i) {
		Collections.sort(league[i].players, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				if(o1.ability == o2.ability) {
					return o2.number - o1.number;
				}
				return o1.ability - o2.ability;
			}
		});

		league[i].maxP = league[i].players.get(n - 1);
		league[i].midP = league[i].players.get(mid);
		league[i].minP = league[i].players.get(0);
	}

}