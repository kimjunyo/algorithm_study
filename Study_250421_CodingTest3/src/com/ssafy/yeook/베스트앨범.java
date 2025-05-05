package com.ssafy.yeook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트앨범 {
	public int[] solution(String[] genres, int[] plays) {
		GenreNode[] genreArr = new GenreNode[100];
		int index = 0;// genreArr에 추가할 인덱스
		Map<String, Integer> genreMap = new HashMap<>(); // 장르 나왔는지 확인.
		for (int i = 0; i < plays.length; i++) {
			String genre = genres[i];
			int count = plays[i];
			// 장르 없으면?
			if (!genreMap.containsKey(genre)) {
				GenreNode g = new GenreNode(genre, count);
				g.songs.add(new SongNode(genre, count, i));
				genreMap.put(genre, index);
				genreArr[index++] = g;

				// 장르 있으면?
			} else {

				SongNode s = new SongNode(genre, count, i);
				int insertIndex = genreMap.get(genre);
				genreArr[insertIndex].songs.add(s);
				genreArr[insertIndex].count += count;

			}
		}

		PriorityQueue<GenreNode> genrepq = new PriorityQueue<>((a, b) -> b.count - a.count);
		for (int i = 0; i < index; i++) {
			genrepq.add(genreArr[i]);
		}
		int[] arr = new int[200];
		int i = 0;

		while (!genrepq.isEmpty()) {
			GenreNode g = genrepq.poll();
			int no = g.songs.poll().no;
			arr[i++] = no;
			if (g.songs.size() > 0) {
				no = g.songs.poll().no;
				arr[i++] = no;
			}

		} // while
		int[] answer = Arrays.copyOf(arr, i);

		return answer;
	}

	class GenreNode {
		String genre;
		int count;
		PriorityQueue<SongNode> songs = new PriorityQueue<>((a, b) -> b.count - a.count);

		GenreNode(String genre, int count) {
			this.genre = genre;
			this.count = count;
		}
	}// GenreNode

	class SongNode {
		String genre;
		int count;
		int no;

		SongNode(String genre, int count, int no) {
			this.genre = genre;
			this.count = count;
			this.no = no;
		}
	}// SongNode

}