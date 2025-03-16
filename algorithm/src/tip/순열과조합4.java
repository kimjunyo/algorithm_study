package tip;

import java.util.Arrays;

public class 순열과조합4 {
	
	//6개의 수 중에 2개를 뽑는 조합을 만들어보기
	//조합이므로 방문처리 안해도 됨
	
	static int[] arr = {1,2,3,4,5,6}; //숫자 6개 중에
	static int cnt = 2; //2개 뽑기
	static int[] num = new int[2]; //2개를 뽑아 담을
	
	private static void findCombination(int depth, int last, int cnt) {
		
		if(depth == cnt) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		/*
		 * 종료조건
		 * 
		 * for문 
		 * num
		 * 방문처리
		 * 재귀
		 * 방문처리
		 */
		
		for(int i=last +1; i<arr.length; i++) {
			num[depth] = arr[i];
			findCombination(depth+1, i, cnt);
		}
		
		
	}
	
	public static void main(String[] args) {
		findCombination(0,-1, 2);
	}
	
	
	
	

}
