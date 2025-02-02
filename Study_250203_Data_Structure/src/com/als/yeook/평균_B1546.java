package com.als.yeook;
import java.util.*;
import java.io.*;
public class 평균_B1546 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0;
        int n = Integer.parseInt(st.nextToken());
        StringTokenizer nums = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(nums.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }
        for (int i = 0; i < n; i++) {
            sum += (arr[i] / max) * 100;

        }
        double avr = sum / n;
        bw.write(String.valueOf(avr));
        bw.flush();
    }

    public static class 숫자의합 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int i = 0; i < n; i++) {
                char num = str.charAt(i);
                sum += num - '0';
            }
            bw.write(String.valueOf(sum));
            bw.flush();
        }
    }

}
