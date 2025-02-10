package com.als.hyobin;

import java.util.Arrays;
import java.util.Scanner;

public class P007_주몽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		sc.nextLine(); // 공백제거
		
		//이진 탐색을 사용하기 위해 미리 정렬
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.sorted().mapToInt(Integer::intValue).toArray();
		
		int count = 0;
		for(int i : arr) {	
			if(Arrays.binarySearch(arr, M - i) >= 0)	
				count++;								
		}			
		
		System.out.println(count / 2);																									
	}						
	
}														
														
//arr의 원소 값인 i값과 더해서 M값이 되는 값을 찾아야 하므로 i + x = M, x = M - i
//따라서 M - i 값을 찾으면 된다.
//이진탐색 메서드는 값이 존재하면 0이상의 값을 반환하므로 반환값이 0 이상이여야 존재하는 것이다.
//원소 전체를 돌기 때문에 서로 짝이 맞는 것들이 2번씩 세어진다. 따라서 2를 나눠준다.
//만약 M이 짝수이고 원소 중에 M의 절반값이 있다면 count가 한번 오버된다.
//하지만 count값은 2n 또는 2n+1로 나오기 때문에 / 연산을 하면 자동으로 제거된다.

//시간복잡도를 생각해보자.
//자바에서 제공하는 sort는 시간복잡도가 nlogn
//이진 탐색은 시간복잡도가 logn인데, 그걸 원소의 개수만큼 하므로 nlogn
//따라서 전체 시간복잡도는 nlogn이다.