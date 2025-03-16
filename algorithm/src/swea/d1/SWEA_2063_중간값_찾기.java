package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2063_중간값_찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		int cnt[] = new int[max+1];
		for(int v : arr) {
			cnt[v] ++;
		}
		for(int i=1; i<cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		int sortArr[] = new int[N];
		for(int i=N-1; i>=0; i--) {
			sortArr[--cnt[arr[i]]]= arr[i];
		}
		System.out.println(sortArr[N/2]);
	}
}
