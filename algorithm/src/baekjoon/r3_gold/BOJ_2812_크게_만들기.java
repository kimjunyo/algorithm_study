package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*단순 구현 
public class BOJ_2812_크게_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int resultLength = N - K;

		List<Integer> numList = new ArrayList<>();
		int[] result = new int[resultLength];

		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			numList.add(input.charAt(i) - '0');
		}

		int start = 0;
		int end = resultLength;
		while (true) {
			int maxIdx = 0; // 1. max값 찾기
			int max = -1;

			for (int i = 0; i < N; i++) {
				if (numList.get(i) > max) {
					max = numList.get(i);
					maxIdx = i;
				}
			}

			int cnt = N - maxIdx;
			if (cnt < resultLength) {
				end -= cnt;
				int idx = end;
				while (cnt > 0) {
					result[idx++] = numList.get(maxIdx);
					numList.remove(numList.get(maxIdx));
					N--;
					resultLength--;
					cnt--;
				}
			} else if (cnt == resultLength) {
				while (cnt > 0) {
					result[start++] = numList.get(maxIdx);
					numList.remove(numList.get(maxIdx));
					N--;
					resultLength--;
					cnt--;
				}
			} else { // cnt>resultLength
				result[start++] = numList.get(maxIdx);
				int tmp = 0;
				while(tmp<=maxIdx) {
					numList.remove(numList.get(0));
					tmp++;
					N--;
				}
				resultLength--;
			}

			if (resultLength == 0)
				break;
		}
		for(int r : result) {
			System.out.print(r);
		}
	}
}
*/

public class BOJ_2812_크게_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Character> s = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int resultLength = N-K;
		
		String input = br.readLine();
		
		for(int i=0; i<input.length();i++) {
			if(s.isEmpty()) s.offerLast(input.charAt(i));
			else if(s.peekLast() < input.charAt(i)) {
				while(!s.isEmpty() && K>0 && s.peekLast()<input.charAt(i)) {
					s.pollLast();
					K--;
				}
				s.offerLast(input.charAt(i));
			}else {
				s.offerLast(input.charAt(i));
			}
			System.out.println("결과"+s);
			System.out.println("K : " + K);
		}
		
		while(resultLength>0) {
			System.out.print(s.pollFirst());
			resultLength--;
		}
		
			
	}
}
