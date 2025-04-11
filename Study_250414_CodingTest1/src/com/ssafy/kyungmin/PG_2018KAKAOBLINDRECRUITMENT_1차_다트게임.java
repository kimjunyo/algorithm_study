import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PG_2018KAKAOBLINDRECRUITMENT_1차_다트게임 {
	static String str = "1S2D*3T\r\n" + "1D2S#10S\r\n" + "1D2S0T\r\n" + "1S*2T*3S\r\n" + "1D#2S*3S\r\n" + "1T2D3D#\r\n"
			+ "1D2S3T*\r\n";

	public static void main(String[] args) {
		Scanner sc = new Scanner(str);
		Solution s = new Solution();
		for (int i = 0; i < 7; i++) {
			int ans = s.solution(sc.nextLine());
			System.out.println(ans);
		}
	}

}

class Solution {
	public int solution(String dartResult) {
		int answer = 0;

		int[] scores = new int[3];

		// () 한 묶음 덩이
		// \\d{1,2} 숫자
		// SDT 중 하나
		// *# 중 하나, 있을수도 있고 없을수도 있고
		Pattern p = Pattern.compile("(10|[0-9])([SDT])([*#]?)");
		Matcher m = p.matcher(dartResult);

		int index = 0;

		// 점수
		while (m.find()) {
			int score = Integer.parseInt(m.group(1));
			scores[index] = score;

			String bonus = m.group(2);
			if (bonus.equals("D")) {
				scores[index] = scores[index] * scores[index];
			} else if (bonus.equals("T")) {
				scores[index] = scores[index] * scores[index] * scores[index];
			}

			String option = m.group(3);
			if (option.equals("*")) {
				if (index == 0) {
					scores[0] *= 2;
				} else {
					scores[index - 1] *= 2;
					scores[index] *= 2;
				}
			} else if (option.equals("#")) {
				scores[index] = -scores[index];
			}

			index++;
		}

		for (int i = 0; i < scores.length; i++) {
			answer += scores[i];
		}
		return answer;
	}
}