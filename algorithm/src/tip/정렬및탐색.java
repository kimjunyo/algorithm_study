package tip;

import java.util.Arrays;

/*
	카운팅정렬
	버블정렬
	선택정렬
	삽입정렬
	이진탐색
 */

public class 정렬및탐색 {

	//
    static void 카운팅정렬(int arr[]) {
        int max = 0;
        for (int v : arr) {
            max = Math.max(max, v);
        }

        int[] cnt = new int[max + 1];
        for (int v : arr) {
            cnt[v]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] sortArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortArr[--cnt[arr[i]]] = arr[i];
        }

        System.out.println("카운팅정렬" + Arrays.toString(sortArr));
    }

    
    static void 버블정렬(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("버블정렬" + Arrays.toString(arr));
    }

    //
    static void 선택정렬(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] < arr[j]) {
                    minIdx = j;
                }
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
            System.out.println( Arrays.toString(arr));
        }
        System.out.println("선택정렬" + Arrays.toString(arr));
    }

    //
    static void 삽입정렬(int arr[]) {
    	for(int i=1; i<arr.length-1; i++) {
    		int key = arr[i];
    		int j = i-1;
    		
    		while(j>=0 && arr[j]>key) {
    			arr[j+1] = arr[j];
    			j--;
    		}
    		arr[j+1] = key;
    		
    	}
    	System.out.println("삽입정렬" + Arrays.toString(arr));
    }
    
    

    //
    static void 이진탐색(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                System.out.println(mid + "번째 인덱스에 위치함");
                return;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    //
    public static void main(String[] args) {
        int[] arr = new int[]{7,8,4,6,6};
        //카운팅정렬(arr);
        //버블정렬(arr);
        선택정렬(arr);
        //삽입정렬(arr);
        //이진탐색(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);
    }
}
