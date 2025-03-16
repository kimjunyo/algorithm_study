package etc;

import java.util.Arrays;

public class 순열과조합2 {

	static int[] arr;
	static int[] num;
	static boolean[] visited;
	
	private static void 순열과조합(int depth,int last) {
		
		if(depth ==2) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=last+1; i<arr.length; i++) {
			if(visited[i]) continue;
			num[depth] = arr[i];
			visited[i] = true;
			순열과조합(depth+1,i);
			visited[i] = false;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		arr = new int[] {1,2,3,4,5,6};
		num = new int[2];
		visited = new boolean[arr.length];
		
		순열과조합(0,-1);
	}
}
