package programmers.lv1;
/*
 X	Y	result
"100"	"2345"	"-1"
"100"	"203045"	"0"
"100"	"123450"	"10"
"12321"	"42531"	"321"
"5525"	"1255"	"552"
 */

import java.util.Arrays;

public class 숫자짝궁 {
	public static void main(String[] args) {
		int[] num1 = new int[10]; // 0 1 2 3 4 5 6 7 8 9
		int[] num2 = new int[10]; // 0 1 2 3 4 5 6 7 8 9
		int[] num3 = new int[10]; // 0 1 2 3 4 5 6 7 8 9
		StringBuilder sb = new StringBuilder();

		String X = "5525";
		String Y = "1255";
		for (int i = 0; i < X.length(); i++) {
			num1[X.charAt(i) - '0']++;
		}
		// System.out.println(Arrays.toString(num1));

		for (int i = 0; i < Y.length(); i++) {
			num2[Y.charAt(i) - '0']++;
		}
		// System.out.println(Arrays.toString(num2));

		for (int i = 0; i < 10; i++) {
			num3[i] = Math.min(num1[i], num2[i]);
		}
		// System.out.println(Arrays.toString(num3));

		for (int i = 9; i >= 1; i--) {
			while (num3[i] != 0) {
				sb.append(i);
				num3[i]--;
			}
		}

		if (sb.length() != 0) {
			if (num3[0] != 0) {
				while (num3[0] != 0) {
					sb.append(0);
					num3[0]--;
				}
			}

		} else {
			if (num3[0] != 0) {
				sb.append(0);
			} else {
				sb.append(-1);
			}
		}
		System.out.println(sb);
	}

}
