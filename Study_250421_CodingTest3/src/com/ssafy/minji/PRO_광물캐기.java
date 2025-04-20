package com.ssafy.minji;

import java.util.*;

// solve 못했어요~~~(80%)
class PRO_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int pickNum = 0;
        for(int p : picks){
            pickNum += p;
        }
        int mineralNum = Math.min(pickNum * 5, minerals.length);
        int diaPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];
        
        List<int[]> mineralGroup = new ArrayList();
        int[] group = new int[5];
        int idx = 0;
        int val;
        for(int i = 0 ; i < mineralNum ; i++){
            String mineral = minerals[i];
            if(idx == 5){
                mineralGroup.add(group);
                group = new int[5];
                idx = 0;
            }
            if(mineral.equals("diamond")){
                val = 31;
            }else if(mineral.equals("iron")){
                val = 6;
            }else{
                val = 1;
            }
            
            group[idx++] = val;
        }
        mineralGroup.add(group);
        
        Collections.sort(mineralGroup, new Comparator<int[]>(){
            @Override
            public int compare (int[] o1, int[] o2){
                int sum1 = 0;
                int sum2 = 0;
                for(int i = 0 ; i < 5 ; i++){
                    sum1 += o1[i];
                    sum2 += o2[i];
                }
                return sum2 - sum1;
            }
        });
        
        for(int[] g : mineralGroup){
            for(int i : g){
                System.out.println(i);
            }
        }
        
        int tired = 0;
        idx = 0;
        while(diaPick > 0 && idx < mineralGroup.size()){
            group = mineralGroup.get(idx++);
            for(int i = 0 ; i < 5 ; i++){
                if(group[i] != 0){
                    tired++;
                }
            }
            diaPick--;
        }
        
        while(ironPick > 0 && idx < mineralGroup.size()){
            group = mineralGroup.get(idx++);
            for(int i = 0 ; i < 5 ; i++){
                if(group[i] == 31){
                    tired += 5;
                }else if(group[i] != 0){
                    tired++;
                }
            }
            ironPick--;
        }
        
        while(stonePick > 0 && idx < mineralGroup.size()){
            group = mineralGroup.get(idx++);
            for(int i = 0 ; i < 5 ; i++){
                if(group[i] == 31){
                    tired += 5;
                }else if(group[i] == 6){
                    tired += 5;
                }else if(group[i] == 1){
                    tired++;
                }
            }
            stonePick--;
        }
        
        return tired;
    }
}