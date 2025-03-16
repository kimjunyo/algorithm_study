package etc;

import java.util.Arrays;

public class 순열과조합3 {
	static int[] arr;
	static int[] num;
	static boolean[] visit;
	
	private static void 순열과조합(int depth, int last) {
		
		/*
		 * 재귀종료 조건 depth 
		 * 
		 * for문
		 * 이미방문 컨티뉴
		 * 
		 * num배열 저장
		 * true
		 * 순열과조합
		 * false
		 * 
		 */
		
		if(depth==num.length) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=last+1; i<arr.length; i++) {
			if(visit[i]) continue;
			
			num[depth] = arr[i];
			visit[i] = true;
			순열과조합(depth+1, i);
			visit[i] = false;
		}
	}
	public static void main(String[] args) {
		arr = new int[] {1,2,3,4,5,6};
		num = new int[2];
		visit = new boolean[arr.length];
		
		순열과조합(0,-1);
		
	}
}
