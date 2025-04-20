package com.ssafy.minji;

import java.util.*;

class PRO_베스트앨범 {
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Genre> album = new HashMap<>();
		List<String> genreList = new ArrayList<>();
		String str;
		Genre genre;
		for (int i = 0; i < genres.length; i++) {
			str = genres[i];
			genre = album.get(str);
			if (genre == null) {
				genreList.add(str);
				genre = new Genre();
				genre.playSum = plays[i];
				genre.firstPlays = plays[i];
				genre.firstIdx = i;
				genre.secondPlays = -1;
				genre.secondIdx = -1;
				album.put(str, genre);
			} else {
				if (genre.firstPlays < plays[i]) {
					genre.secondPlays = genre.firstPlays;
					genre.secondIdx = genre.firstIdx;

					genre.firstPlays = plays[i];
					genre.firstIdx = i;
				} else if (genre.secondPlays < plays[i]) {
					genre.secondPlays = plays[i];
					genre.secondIdx = i;
				}
				genre.playSum += plays[i];
			}
		}

		Collections.sort(genreList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return album.get(o2).playSum - album.get(o1).playSum;
			}
		});

		List<Integer> answerList = new ArrayList<>();
		for (String genreName : genreList) {
			answerList.add(album.get(genreName).firstIdx);
			if (album.get(genreName).secondIdx != -1) {
				answerList.add(album.get(genreName).secondIdx);
			}
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}

class Genre {
	int playSum;
	int firstPlays;
	int firstIdx;
	int secondPlays;
	int secondIdx;

	public int getPlaySum() {
		return playSum;
	}

	public void setPlaySum(int playSum) {
		this.playSum = playSum;
	}

	public int getFirstPlays() {
		return firstPlays;
	}

	public void setFirstPlays(int firstPlays) {
		this.firstPlays = firstPlays;
	}

	public int getFirstIdx() {
		return firstIdx;
	}

	public void setFirstIdx(int firstIdx) {
		this.firstIdx = firstIdx;
	}

	public int getSecondPlays() {
		return secondPlays;
	}

	public void setSecondPlays(int secondPlays) {
		this.secondPlays = secondPlays;
	}

	public int getSecondIdx() {
		return secondIdx;
	}

	public void setSecondIdx(int secondIdx) {
		this.secondIdx = secondIdx;
	}
}
