package com.ssafy.yeook;

import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[5];
        
        StringBuilder str = new StringBuilder(dartResult);
        int index = 1;
        for(int i = 0;i < str.length();i++){
        
            char c = str.charAt(i);
            
            if('0'<=c && c<='9'){
                if(i>0 && str.charAt(i-1)=='1' && c=='0'){
                    arr[index-1]=10;
                }else{
                    arr[index++] = c-'0';
                }
            }
            if(c=='*'){
                arr[index-1] *= 2;
                if(index>=2){
                    arr[index-2] *=2;
                }
            }
            
            if(c=='#'){
                arr[index-1] *= -1;
            }
            
            if(c=='D'){
                arr[index-1] *=arr[index-1];
            }
            
            if(c=='T'){
                arr[index-1]=arr[index-1]*arr[index-1]*arr[index-1];
            }
            
        }
        int answer = 0;
        for(int i = 1;i<=3;i++){
            answer += arr[i];
        }
        
        
        return answer;
    }
}