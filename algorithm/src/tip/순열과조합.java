package tip;

import java.util.Arrays;


//순열임!
public class 순열과조합 {
	
	static int[] arr; //선택할 수 있는 숫자들을 담은 배열
	static int[] num; //선택할 숫자를 담을 배열 //num==arr.length이면 순열 // num == 특정 숫자이면 조합
	static boolean[] visited;
	static int what = 2; //조합
	//static int what = arr.length; //순열
	
	//각 단계마다 숫자 하나를 선택
	static void permutation(int depth, int lastIdx) {
		
		if(depth == what) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=lastIdx+1; i<arr.length;i++) {
			if(visited[i]) continue; 
			num[depth] = arr[i];
			visited[i] = true;  //중복 처리 허용이면 주석으로 막기
			permutation(depth+1,i);
			visited[i] = false; //중복 처리 허용이면 주석으로 막기
		}
	}
	
	public static void main(String[] args) {
		arr = new int[] {1,2,3,4,5,6};
		num = new int[what];
		visited = new boolean[arr.length];
		
		permutation(0,-1);
	}

}
