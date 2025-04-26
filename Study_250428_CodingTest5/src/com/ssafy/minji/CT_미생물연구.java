package com.ssafy.minji;

import java.io.*;
import java.util.*;

// 못풀었어여
public class CT_미생물연구 {
    static int N;
    static int Q;
    static int[][] map;
    static Map<Integer, List<Integer>> micro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        micro = new LinkedHashMap();
        int r1,c1, r2, c2, point;
        for(int microNum = 1 ; microNum <= Q ; microNum++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            
            newMicro(microNum, r1, c1, r2, c2);

//            Collections.sort(micro, new Comparator<Integer>(){
//                @Override
//                public int compare(Integer o1, Integer o2){
//                    int returnVal = 0;
//                    if(micro.get(o1).size() > micro.get(o2).size()){
//                        returnVal = 1;
//                    }else if(micro.get(o1).size() < micro.get(o2).size()){
//                        returnVal = -1;
//                    }else{
//                        returnVal = o1 - o2;
//                    }
//                    return returnVal;
//                }
//            });

            for(int i = 0 ; i < N ; i++){
                Arrays.fill(map[i], 0);
            }
            
            for(int m : micro.keySet()){
                
            }

        }

    }

    static void newMicro(int microNum, int r1, int c1, int r2, int c2){
        List<Integer> list = new ArrayList();
        for(int r = r1 ; r <= r2 ; r++){
            for(int c = c1 ; c <= c2 ; c++){
                int point = N * r + c;
                if(map[r][c] != 0){
                    micro.get(map[r][c]).remove(Integer.valueOf(point));
                }
                map[r][c] = microNum;
                micro.put(microNum, list);
            }
        }
    }

    static void moveMicro(int microNum){
        List<Integer> list = micro.get(microNum);
        int pointR = list.get(0) / N;
        int pointC = list.get(0) % N;
        int moveR, moveC;
        for(int j = 0 ; j < N ; j++){
            for(int i = 0 ; i < N ; i++){
                if(map[i][j] == 0){
                    moveR = i - pointR;
                    moveC = j - pointC;
                    for(int p = 0 ; p < list.size() ; p++){
                        // list.get(0)
                    }
                }
            }
        }

    }

}