package baekjoon.r2_silver;
import java.util.Arrays;
import java.util.Scanner;

/*
//1차 : 중첩반복문 사용 O(n^2)
public class BOJ_2018_수들의_합5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] numArr = new int[n];
		
		for(int i=0; i<n; i++) {
			numArr[i]=i+1;
		}
		//System.out.println(Arrays.toString(numArr));
		
		int count =0;	
		int idx =0;
		int time = n;
		while(time>0) {
			int check = 0;
			for(int i=idx; i<n; i++) {
				check += numArr[i];
				if(check == n) {
					//System.out.println(idx+" " + i);
					count++;
					break;
				}
				else if(check > n) break;
			}
			time--;
			idx++;
		}
		System.out.println(count);
	}
}
*/

//2차 투포인터 사용
public class BOJ_2018_수들의_합5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] numArr = new int[n];
		
		int front= 1;
		int rear = 1;
		int sum = 1;
		int count =1;
		
		while(rear != n) {
			if(sum == n) {
				count ++;
				sum += ++rear;
			}else if(sum > n) {
				sum -= front++;		
			}else { //sum<n
				sum += ++rear;
			}
		}	
		System.out.println(count);	
	}
}