package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_최대상금 {
	static int max;
	static int[] idx;
	static int[] arr;
	static int[] arr2;
	static int[] swapIdx;
	static boolean[] visit;
	
	private static boolean isMax(int[] check) {
		int num = arr.length-1;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum+= check[i] * Math.pow(10, num--);
		}
		//System.out.println("숫자는 : " +sum);
		if(sum>max) {
			
			return true;
		}
	}
	
	
	private static void swap(int i, int j) {
		int[] check = arr;
		int tmp = check[i];
		check[i] = check[j];
		check[j] = tmp;
		//System.out.println("swap : " + Arrays.toString(arr2));
		isMax(check);
	}
	
	private static void findIdx(int depth) {
		if(depth == 2) {
			//System.out.println(swapIdx[0] +"    "+ swapIdx[1]);
			swap(swapIdx[0], swapIdx[1]);
			return;
		}
		
		for(int i=0; i<idx.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				swapIdx[depth] = idx[i];
				findIdx(depth+1);
				visit[i] = false;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int swapCnt = Integer.parseInt(st.nextToken());
			arr = new int[input.length()];
			arr2 = new int[input.length()];
			visit = new boolean[input.length()];
			idx = new int[input.length()];
			swapIdx = new int[2];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = input.charAt(i)-'0';
				idx[i] = i;
			}
			
			max = 0;
			while(swapCnt>0) {
				findIdx(0);
				swapCnt--;
			}
			System.out.println(max);
		}
	}
}
