package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class PG_42579_베스트앨범 {
	static String[][] genres = { { "classic", "pop", "classic", "classic", "pop" } };
	static int[][] plays = { { 500, 600, 150, 800, 2500 }, };

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i = 0; i < genres.length; i++) {
			int[] ans = s.solution(genres[i], plays[i]);
			System.out.println(Arrays.toString(ans));
		}
	}

	static class Solution {
		class Genre implements Comparable<Genre> {
			String name;
			int total;

			Genre(String name, int total) {
				this.name = name;
				this.total = total;
			}

			@Override
			public int compareTo(Genre o) {
				return Integer.compare(o.total, this.total);
			}

			@Override
			public String toString() {
				return "Genre [name=" + name + ", total=" + total + "]";
			}

		}

		class Song implements Comparable<Song> {
			int index;
			int play;

			Song(int index, int play) {
				this.index = index;
				this.play = play;
			}

			@Override
			public int compareTo(Song o) {
				if (o.play == this.play) {
					return Integer.compare(this.index, o.index);
				}
				return Integer.compare(o.play, this.play);
			}

			@Override
			public String toString() {
				return "Song [index=" + index + ", play=" + play + "]";
			}

		}

		public int[] solution(String[] genres, int[] plays) {
			List<Integer> answer = new ArrayList<>();

			Map<String, Integer> genreTotal = new HashMap<>();
			PriorityQueue<Genre> genrePQ = new PriorityQueue<>();
			Map<String, PriorityQueue<Song>> category = new HashMap<>();

			for (int i = 0; i < genres.length; i++) {
				genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);

				if (category.containsKey(genres[i])) {
					PriorityQueue<Song> pq = category.get(genres[i]);

					Song song = new Song(i, plays[i]);

					if (pq.size() == 2) {
						Song[] arr = new Song[2];
						int idx = 0;
						for (Song s : pq) {
							arr[idx++] = s;
						}

						if (song.play > arr[0].play || song.play > arr[1].play) {
							pq.offer(song);
							pq.remove(arr[1]);
						}
					} else {
						pq.offer(song);
					}
				} else {
					PriorityQueue<Song> pq = new PriorityQueue<>();
					pq.offer(new Song(i, plays[i]));
					category.put(genres[i], pq);
				}

			}

			for (Entry<String, Integer> g : genreTotal.entrySet()) {
				genrePQ.offer(new Genre(g.getKey(), g.getValue()));
			}
			
			while (!genrePQ.isEmpty()) {
				Genre g = genrePQ.poll();
				for (Song song : category.get(g.name)) {
					answer.add(song.index);
				}
			}

			int idx = 0;
			int[] a = new int[answer.size()];
			for (int index : answer) {
				a[idx++] = index;
			}

			return a;
//			return answer.stream().mapToInt(i -> i).toArray();
		}
	}
}
