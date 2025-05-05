package com.ssafy.yeook;

import java.util.PriorityQueue;

public class 광물캐기 {

	public int solution(int[] picks, String[] minerals) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
		int maxIndex = -1;
		for (int i = 0; i < picks.length; i++) {
			maxIndex += (5 * picks[i]);
		}
		int i = 0;
		while (i <= maxIndex && i < minerals.length) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				int curIndex = i + j;
				if (curIndex > maxIndex || curIndex >= minerals.length)
					break;
				if (minerals[curIndex].equals("diamond"))
					sum += 25;
				if (minerals[curIndex].equals("iron"))
					sum += 5;
				// if(minerals[curIndex].equals("stone")) sum+=0;
			}
			pq.add(new Node(i, sum));
			i += 5;
		} // while

		i = 0;
		int answer = 0;

		while (!pq.isEmpty() && i < 3) {
			if (picks[i] == 0) {
				i++;
				continue;
			}
			Node node = pq.poll();
			int start = node.startIndex;

			for (int j = start; j < start + 5; j++) {
				if (j >= minerals.length)
					break;
				answer += fatigue(i, minerals[j]);
			}
			picks[i]--;

		}
		return answer;
	}

	int fatigue(int index, String str) {
		if (index == 0)
			return 1;
		else if (index == 1) {
			if (str.equals("diamond"))
				return 5;
			else
				return 1;
		} else {
			if (str.equals("diamond"))
				return 25;
			else if (str.equals("iron"))
				return 5;
			else
				return 1;
		}
	}

	class Node {
		int startIndex;
		int sum;

		Node(int startIndex, int sum) {
			this.startIndex = startIndex;
			this.sum = sum;
		}
	}
}