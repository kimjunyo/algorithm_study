package tip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1~6까지 수가 있을 때 2/4 묶음으로 나눠보기

public class 순열과조합5 {
	
	
	static int[] arr = new int[] {1,2,3,4,5,6};
	static int[] num = new int[2];
	static List<List<List<Integer>>> list = new ArrayList<>();
	
	
	private static void Combination(int depth, int last, int cnt) {
		
		if(depth ==cnt) {
			
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();
			
			for(int a : num) {
				group1.add(a);
			}
			
			for(int i=0; i<arr.length; i++) {
				if(!group1.contains(arr[i])) {
					group2.add(arr[i]);
				}
			}
			list.add(Arrays.asList(group1,group2));
			return;
			//종료조건
		}
		
		for(int i = last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			Combination(depth+1, i, cnt);
		}
	}
	
	
	public static void main(String[] args) {
		
		Combination(0,-1,2);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
