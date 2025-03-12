package com.ssafy.yeook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수2_11501 {
	public static int n;
	public static int k;
	public static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		arr[0] = arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			arr[i] = ((arr[i - 1] % 10007) * (i % 10007)) % 10007;
		}
		// b^-1 = b^(mod-2) (단 mod는 소수).
		// a/b = a*b^-1
		// b^-1 = (b^mod-2)%mod
		// (b*b^-1)%mod = 1인 b^-1찾기
		int denominator = (arr[k] * arr[n - k]) % 10007;
		int denominatorInverse = pow(denominator, 10005);

		System.out.println((arr[n] * denominatorInverse) % 10007);

	}

	// 밑=base, 지수=exponent
	public static int pow(int base, int exp) {
		int result = 1;
		while (exp > 0) {
			if (exp % 2 == 1) {
				result = (result * base) % 10007;
			}
			base = (base * base) % 10007;
			exp /= 2;
		}
		return result;
	}

}
