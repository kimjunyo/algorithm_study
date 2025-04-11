package com.ssafy.minji;

import java.lang.*;

class Solution {
    static int ans;
    public int solution(String dartResult) {
        ans = 0;
        int idx = 0;
        char next;
        int val;
        int lastVal = 0;
        
        while(idx < dartResult.length()){
            next = dartResult.charAt(idx++);
            if(next == '1' && idx < dartResult.length() && dartResult.charAt(idx) == '0'){
                val = 10;
                idx++;
            }else{
                val = next - '0';
            }
            
            next = dartResult.charAt(idx++);
            if(next == 'S'){
                val = singleAdd(val);
            }else if(next == 'D'){
                val = doubleAdd(val);
            }else if(next == 'T'){
                val = tripleAdd(val);
            }
            
            
            if(idx < dartResult.length()){
                next = dartResult.charAt(idx);
                if(next == '*'){
                    val = star(val);
                    ans += lastVal;
                    idx++;
                }else if(next == '#'){
                    val = acha(val);
                    idx++;
                }           
            }
            
            ans += val;
            lastVal = val;
        }
        return ans;
    }
    
    public int singleAdd(int n){
        return n;
    }    
    
    public int doubleAdd(int n){
        return (int)Math.pow(n, 2);
    }
    
    public int tripleAdd(int n){
        return (int)Math.pow(n, 3);
    }

    public int star(int n){
        return n * 2;
    }
    
    public int acha(int n){
        return n * -1;
    }
}