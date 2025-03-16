package etc;

import java.util.Arrays;
public class 연습 {
	
	static int[] arr = {4,5,8,1,5,7,8,1};
	static int[] num;
	
	private static void 카운팅() {
		int max = arr[0];
		for(int n : arr) {
			max = Math.max(n, max);
		}
		
		int[] cnt = new int[max+1];
		for(int n : arr) {
			cnt[n]++;
		}
		
		for(int i=1; i<cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		int[] sortArr = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			sortArr[--cnt[arr[i]]] = arr[i];
		}
		System.out.println("카운팅 : " +Arrays.toString(sortArr));
	}
	
	
	private static void 삽입() {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key; 
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static void 부분집합(int depth, int last, int cnt) {
	
		if(depth == cnt) {
			System.out.println("부분집합 : " + Arrays.toString(num));
			return;
		}
		
		
		for(int i = last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			부분집합(depth+1, i, cnt);
		}
	}
	
	
	
	public static void main(String[] args) {
		//카운팅();
		삽입();
		
//		for(int i=1; i<arr.length; i++) {
//			num = new int[i];
//			부분집합(0,-1,i);
//		}
	}

}
