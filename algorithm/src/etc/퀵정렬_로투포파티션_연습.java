package etc;

import java.util.Arrays;

public class 퀵정렬_로투포파티션_연습 {
	static int[] arr = { 7, 5, 6, 8, 1, 2, 3, 39 };
	static int N = arr.length;
	
	private static void quickSort(int start, int end) {
		if(start<end) {
			int pivot = partition(start,end);
			quickSort(start, pivot -1);
			quickSort(pivot+1, end);
		}
		
	}
	
	private static int partition(int start, int end) {
		
		int pivot = arr[end];
		int i = start-1;
		
		for(int j=start; j<end; j++) {
			if(arr[j]<=pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = tmp;
		
		return i+1;
	}
	
	public static void main(String[] args) {
		quickSort(0, N - 1);
		
		System.out.println(Arrays.toString(arr));
	}
}
