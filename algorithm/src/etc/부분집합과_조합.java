package etc;

import java.util.Arrays;
/*
public class 부분집합과_조합 {
	
	static int[] arr;
	static int[] num;
	
	private static void findCombination(int depth, int last, int cnt) {
		
		if(depth == cnt) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			findCombination(depth+1, i, cnt);
		}
	}
	
	
	public static void main(String[] args) {
		
		arr = new int[]{1,2,3,4,5};
		
		for(int cnt=1; cnt<=5; cnt++) {
			num = new int[cnt];
			findCombination(0,-1, cnt);
		}
	}
}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 부분집합과_조합 {
    
    static int[] arr;
    static List<Integer> subset;

    private static void findSubset(int index) {
        if (index == arr.length) { // 모든 원소를 탐색했을 때
            System.out.println(subset);
            return;
        }
        
        // 1) 현재 원소를 포함하지 않는 경우
        findSubset(index + 1);
        
        // 2) 현재 원소를 포함하는 경우
        subset.add(arr[index]);
        findSubset(index + 1);
        subset.remove(subset.size() - 1); // 원상복구 (백트래킹)
    }
    
    public static void main(String[] args) {
        arr = new int[]{1,2,3,4,5};
        subset = new ArrayList<>();
        findSubset(0);
    }
}

