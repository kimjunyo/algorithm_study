package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4698_테니스의_특별한_소수 {
	static int B;
	
	/*
	private static boolean[] isNotPrime;  // false면 소수

	// 에라토스테네스의 체 초기화
	private static void initPrimes() {
	    isNotPrime[0] = isNotPrime[1] = true;

	    for(int i = 2; i * i <= B; i++) {
	        if(!isNotPrime[i]) { //소수라면
	            for(int j = i * i; j <= B; j += i) {
	                isNotPrime[j] = true; //소수가 아님
	            }
	        }
	    }
	}
	*/
	
	private static boolean[] isNotPrime;
	
	private static void initPrimes() {
		isNotPrime[0] = isNotPrime[1] == true; //소수가 아님
		
		for(int i=2; i*i<=B; i++) {
			if(!isNotPrime[i]) { //소수라면
				for(int j=i*i; j<=B; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}

	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			isNotPrime = new boolean[B+1];
			initPrimes();
			
			int cnt = 0;
			for(int i=A; i<=B; i++) {
				if(!isNotPrime[i]) {
					String check = String.valueOf(i);
					if(check.contains(D)) cnt++;
				}
			}
		
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
