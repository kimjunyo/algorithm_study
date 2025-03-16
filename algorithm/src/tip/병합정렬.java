package tip;

import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = {7,5,6,8,1,2,3,39};
	static int N = arr.length;
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int start, int end) {
		
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			//병합하는 메서드 호출
			merge(start, mid, end);
		}
	}
	
	static void merge(int start, int mid, int end) {
		//정렬하고자 하는 부분 배열들의 시작위치를 초기화
 		int L = start; 
		int R = mid+1;
		
		int idx = start; //임시공간의 인덱스
		
		while(L <= mid && R <= end) {
			if(arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			}else {
				tmp[idx++] = arr[R++];
			}
		}//한쪽구간은 전부 끝
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for(int i = R; i<= end; i++) {
				tmp[idx++] = arr[i];
			}
		} //남은 구간 다 털기
		
		
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}//원본에 덮기
	}
}
