package com.ssafy.junyoung;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<Song>> songMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                
            } else {
                map.put(genres[i], plays[i]);
                songMap.put(genres[i], new PriorityQueue());
            }
            songMap.get(genres[i]).offer(new Song(i, plays[i]));
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
           @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        List<Integer> ans = new ArrayList<>();
        
        for(String key : keySet) {
            PriorityQueue<Song> songs = songMap.get(key);
            
            for(int i=0; i<2 && !songs.isEmpty(); i++) {
                ans.add(songs.poll().no);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

class Song implements Comparable<Song> {
    int no, time;
    
    public Song(int no, int time) {
        this.no = no;
        this.time = time;
    }
    
    @Override
    public int compareTo(Song o) {
        if(this.time == o.time) {
            return this.no - o.no;
        }
        return o.time - this.time;
    }
}