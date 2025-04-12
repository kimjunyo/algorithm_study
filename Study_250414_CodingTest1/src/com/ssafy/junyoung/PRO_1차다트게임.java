package com.ssafy.junyoung;

import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dartArr = dartResult.toCharArray();

        int[] answerArr = new int[3];
        int i = -1;
        int before = 0;
        for(char c : dartArr) {
            switch(c) {
                case 'S':
                    break;
                case 'D':
                    answerArr[i] = answerArr[i] * answerArr[i];
                    break;
                case 'T':
                    answerArr[i] = answerArr[i] * answerArr[i] * answerArr[i];
                    break;
                case '*':
                    if(i == 0) answerArr[i] = answerArr[i] * 2;
                    else {
                        answerArr[i-1] = answerArr[i-1] * 2;
                        answerArr[i] = answerArr[i] * 2;
                    }
                    break;
                case '#':
                    answerArr[i] = answerArr[i] * (-1);
                    break;
                case '0':
                    if(i >= 0 && answerArr[i] == 1) {
                        answerArr[i] *= 10;
                        break;
                    }
                default:
                    answerArr[++i] = c-'0';
            }
        }
        for(i=0; i<3; i++) {
            answer += answerArr[i];
        }

        return answer;
    }
}
