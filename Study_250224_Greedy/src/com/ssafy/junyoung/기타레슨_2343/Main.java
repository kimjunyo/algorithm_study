package com.ssafy.junyoung.기타레슨_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startFirst = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > startFirst) {
                startFirst = arr[i];
            }
        }

        System.out.println(lowerCase(startFirst, sum, M));
    }

    private static int lowerCase(int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (getCount(mid) > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getCount(int mid) {
        int remain = mid;
        int count = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] > remain) {
                remain = mid;
                count++;
            }
            remain -= arr[i];
        }

        return count;
    }
}
