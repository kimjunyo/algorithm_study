package com.ssafy.junyoung;

class Solution {
    private int min;
    
    public int solution(int[] picks, String[] minerals) {
        min = Integer.MAX_VALUE;
        
        perm(0, 0, picks, minerals);
        
        return min;
    }
    private void perm(int count, int start, int[] picks, String[] minerals) {
        for(int i=0; i<3; i++) {
            if(picks[i] == 0) continue;
            
            int remember = count;
            int j;
            
            for(j=start; j<start+5 && j<minerals.length; j++) {
                switch(minerals[j]) {
                    case "diamond":
                        if(i == 0) {
                            remember += 1;
                        } else if (i == 1) {
                            remember += 5;
                        } else {
                            remember += 25;
                        }
                        break;
                    case "iron":
                        if(i == 2) {
                            remember += 5;
                        } else {
                            remember += 1;
                        }
                        break;
                    case "stone":
                        remember += 1;
                        break;
                }
            }
            
            picks[i]--;
            if(isEmpty(picks) || j == minerals.length) {
                min = Integer.min(min, remember);
            }
            perm(remember, start+5, picks, minerals);
            picks[i]++;
        }
    }
    private boolean isEmpty(int[] picks) {
        for(int i=0; i<3; i++) {
            if(picks[i] != 0) {
                return false;
            }
        }
        return true;
    }
}