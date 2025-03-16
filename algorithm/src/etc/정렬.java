package etc;

import java.util.Arrays;

public class 정렬 {
    static int[] arr = { 10, 11, 9, 8, 5, 5 };

    private static void 버블정렬(int[] arr) {
        
    }

    private static void 선택정렬(int[] arr) {
        
    }
    
    private static void 카운팅정렬(int[] arr) {
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
    	for(int i= arr.length-1; i>=0; i--) {
    		sortArr[--cnt[arr[i]]] = arr[i];
    	}
    	
    	System.out.println(Arrays.toString(sortArr));
        
    }

    private static void 이진검색(int key) {
        
    }
    
    private static void 삽입정렬(int[] arr) {
    	
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
    
    private static void 힙정렬(int[] arr) {
        
    }
    
    private static void 병합정렬(int[] arr, int start, int end) {
        
    }

    private static void 퀵정렬_호어(int[] arr, int start, int end) {
        
    }
    
    private static void 퀵정렬_로무토(int[] arr, int start, int end) {
        
    }
    
    public static void main(String[] args) {
        버블정렬(arr.clone());
        선택정렬(arr.clone());
        카운팅정렬(arr);
        이진검색(9);
        arr = new int[] { 10, 11, 9, 8, 5, 5 };
        삽입정렬(arr.clone());
        힙정렬(arr.clone());
        병합정렬(arr.clone(), 0, arr.length-1);
        퀵정렬_호어(arr.clone(), 0, arr.length-1);
        퀵정렬_로무토(arr.clone(), 0, arr.length-1);
    }


}