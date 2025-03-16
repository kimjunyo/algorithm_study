package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14229_백만_개의_정수_정렬 {
	
	static int[] arr;
	
	private static void quickSort(int start, int end) {
		
		if(start<end) {
			int pivot = partition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	private static int partition(int start, int end) { 
	    int pivot = arr[end];
	    int i = start - 1; 

	    for (int j = start; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	            int tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	        }
	    } 

	    int tmp = arr[i + 1];
	    arr[i + 1] = arr[end];
	    arr[end] = tmp;
	    return i + 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000000];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		quickSort(0,1000000-1);
		System.out.println(arr[500000]);
	}
}
