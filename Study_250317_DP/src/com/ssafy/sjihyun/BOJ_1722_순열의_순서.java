package com.ssafy.sjihyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1722_순열의_순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> numList = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
        	numList.add(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int caseNum = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if (caseNum == 1) {
        	
        	long targetArr = Long.parseLong(st.nextToken()) - 1;
        	for(int i=N-1; i>=0; i--) {
        		int idx = (int) (targetArr/factorial[i]);
        		sb.append(numList.get(idx)).append(" ");
        		numList.remove(idx);
        		targetArr %= factorial[i];
        	}

        } else {
            long targetNum = 1;
            int[] input = new int[N];

            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                int idx = numList.indexOf(input[i]);
                targetNum += idx * factorial[N - 1 - i];
                numList.remove(idx);
            }
            sb.append(targetNum);
        }

        System.out.println(sb);
    }
}
