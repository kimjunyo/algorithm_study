package etc;

import java.util.Arrays;

public class 병합정렬_연습2 {
	static int[] arr = { 7, 5, 6, 8, 1, 2, 3, 39 };
	static int N = arr.length;
	static int[] tmp = new int[N];
	
	
	private static void mergeSort(int start, int end) {
		
		if(start<end) {
			int mid = (start+end)/2;
			
			mergeSort(start,mid);
			mergeSort(mid+1, end);
			merge(start,mid,end);
		}
	}
	
	private static void merge(int start, int mid, int end) {
		
		int L = start;
		int R = mid +1;
		
		int idx = start;
		
		
		while(L<= mid && R <= end) {
			if(arr[L]<= arr[R]) {
				tmp[idx++] = arr[L++];
			}else {
				tmp[idx++] = arr[R++];
			}
		}
		
		if(L<= mid) {
			for(int i=L; i<= mid; i++) {
				tmp[idx++] = arr[i];
			}
			
		}else {
			for(int i=R; i<= end; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		for(int i=start; i<=end; i++) {
			arr[i] = tmp[i];
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
		
		
	}

}
