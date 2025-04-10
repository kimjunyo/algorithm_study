/*
 * 
 * BFS
 * 
package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2023_신기한_소수 {
	
	static List<Integer>[] list;
//	static List<Integer> first = new ArrayList<>();
//	static {
//	    first.add(2);
//	    first.add(3);
//	    first.add(5);
//	    first.add(7);
//	}
//	static List<Integer> second = new ArrayList<>();
//	static List<Integer> third = new ArrayList<>();
	
	private static boolean checkPrime(int num) {
		
		if(num <2) return false;
		for(int i=2; i*i <= num ; i++) {
			if(num % i ==0 ) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		list[0].add(2);
		list[0].add(3);
		list[0].add(5);
		list[0].add(7);
//		System.out.println(list[0]);
		
		for(int i=0; i<N-1; i++) {
//			System.out.println("::::::::::::::::::::::: I : " + i);
			for(int n : list[i]) {
//				System.out.println("현재 n :::::::  "+ n);
				for(int s=0; s<10; s++) {
//					System.out.println("현재 s :::::::  "+ s);
					int num = n*10 + s;
//					System.out.println("검사하는 수 :::::::  "+ num);
					if(checkPrime(num)) {
//						System.out.println("여기2");
						list[i+1].add(num);
					}
				}
			}
//			System.out.println(list[i+1]);
//			System.out.println("출력합니다~여기까지왔어요~~");
		}
//		System.out.println(list[N-1]);
		for(int result : list[N-1]) {
			System.out.println(result);
		}
		
//		
//		for(int num1 : first) {
//			for(int s=0; s<10; s++) {
//				int num2 = num1*10 + s;
//				if(checkPrime(num2)) second.add(num2);
//			}
//		}
//		System.out.println(second);
//		
//		for(int num2 : second) {
//			for(int s=0; s<10; s++) {
//				int num3 = num2*10 + s;
//				if(checkPrime(num3)) third.add(num3);
//			}
//		}
//		System.out.println(third);
	}
}
*/

//DFS
package com.ssafy.jihyun;

import java.util.Scanner;

public class BOJ_2023_신기한_소수 {

    private static boolean checkPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static void dfs(int num, int depth, int N) {
        if (depth == N) { 
            System.out.println(num);
            return;
        }

        for (int s = 0; s < 10; s++) { 
            int nextNum = num * 10 + s;
            if (checkPrime(nextNum)) {
                dfs(nextNum, depth + 1, N);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);
    }
}

