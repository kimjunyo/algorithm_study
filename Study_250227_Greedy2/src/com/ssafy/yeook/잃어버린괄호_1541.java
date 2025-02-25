package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 잃어버린괄호_1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] nums = str.split("[-,+]"); // 숫자들만 담을 배열.
		char[] strc = str.toCharArray();
		ArrayList<Character> operators = new ArrayList<>(); // 부호들만 담을 리스트.
		for (char c : strc) {
			if (c == '-' || c == '+')
				operators.add(c);
		}
		int i = 0;// 부호 리스트의 인덱스
		int j = 1;// 숫자 배열의 인덱스
		int sum = Integer.parseInt(nums[0]);

		while (i < operators.size() && j < nums.length) {
			// 다음 부호도 -이면 현재 수 빼버림.
			if (operators.get(i) == '-') {
				if (i == operators.size() - 1 || operators.get(i + 1) == '-') {
					sum -= Integer.parseInt(nums[j++]);
					i++;

					// 괄호는 두 수만 묶는 것이 아니라 여러수를 묶을 수 있음.!!
					// 현재 -이고 다음부호 +이면 모두 더해서 빼버림.
				} else {
					int cursum = Integer.parseInt(nums[j++]);
					i++;

					while (i < operators.size() && operators.get(i) == '+') {
						cursum += Integer.parseInt(nums[j++]);
						i++;
					}
					sum -= cursum;
				}
			} else {
				sum += Integer.parseInt(nums[j++]);
				i++;
			}

		}
		System.out.println(sum);

	}
}
