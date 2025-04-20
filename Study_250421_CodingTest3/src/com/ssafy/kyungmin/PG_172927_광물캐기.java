import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_172927_광물캐기 {
	static int[][] picks = { { 1, 3, 2 }, { 0, 1, 1 }, { 1, 3, 2 }, { 0, 0, 1 } };
	static String[][] minerals = { { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" },
			{ "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron",
					"diamond" },
			{ "iron", "iron", "iron", "stone", "diamond", "iron", "diamond", "diamond", "diamond", "iron", "diamond" },
			{ "iron", "iron", "iron", "stone", "diamond", "iron", "diamond", "diamond", "diamond", "iron",
					"diamond" } };

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i = 0; i < picks.length; i++) {
			int ans = s.solution(picks[i], minerals[i]);
			System.out.println(ans);
		}
	}

	// 작업을 끝내기까지 최소한의 피로도
	// 1. 곡괭이를 다 쓰거나
	// 2. 광물을 다 캐거나
	static class Solution {
		public int solution(int[] picks, String[] minerals) {
			// 개수, 최대 5개
			int diamond = picks[0];
			int iron = picks[1];
			int stone = picks[2];

			int pickSum = diamond + iron + stone;
			int mIdx = 0;
			int fatigue = 0;

			List<int[]> list = new ArrayList<>();
			while (mIdx < minerals.length && mIdx / 5 < pickSum) {
				int[] weights = new int[3];
				for (int i = mIdx; i < Math.min(mIdx + 5, minerals.length); i++) {
					weights[0]++;

					switch (minerals[i]) {
					case "diamond":
						weights[1] += 5;
						weights[2] += 25;
						break;
					case "iron":
						weights[1] += 1;
						weights[2] += 5;
						break;
					default:
						weights[1] += 1;
						weights[2] += 1;
						break;
					}
				}
				list.add(weights);
				mIdx += 5;
			}

			list.sort((a, b) -> {
				int sumA = a[0] + a[1] + a[2];
				int sumB = b[0] + b[1] + b[2];
				return sumB - sumA;
			});
			for (int[] e : list) {
				if (diamond > 0) {
					fatigue += e[0];
					diamond--;
				} else if (iron > 0) {
					fatigue += e[1];
					iron--;
				} else if (stone > 0) {
					fatigue += e[2];
					stone--;
				} else
					break;
			}

			return fatigue;
		}
	}
}
