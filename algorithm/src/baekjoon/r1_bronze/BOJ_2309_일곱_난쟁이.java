package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱_난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int find = sum-100;
		Arrays.sort(arr);
		int left = 0;
		int right = 8;
		while(left<right) {
			if(arr[left] + arr[right] > find) {
				right--;
			}else if(arr[left] + arr[right] < find){ 
				left++;
			}else { //같을 때
				break;
			}
		}
		for(int i=0; i<9; i++) {
			if(i==left || i==right) continue;
			System.out.println(arr[i]);
		}
	} 
}
