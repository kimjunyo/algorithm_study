package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class IM대비5_봉사활동 {
	static int result = 1001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score);
			int maxScore = score[N-1];
			
			int[] cnt = new int[maxScore+1];
			Set<Integer> unique = new LinkedHashSet<>();
			for(int v : score) {
				cnt[v]++;
				if(v != 0) {
					unique.add(v);
				}
			}
//			System.out.println("카운팅" +Arrays.toString(cnt));
			List<Integer> uniqueList = new ArrayList<>(unique);
			
//			System.out.println("고유 점수만(인덱스 역할)" +uniqueList);
			
			int[] cntSum = new int[cnt.length];
			for(int i=1; i<cnt.length; i++) {
				cntSum[i] = cnt[i] + cntSum[i-1];
			}
//			System.out.println("누적합" +Arrays.toString(cntSum));
			
			
			for(int i=1; i< uniqueList.size()-1; i++) {
				//score2 이상 : 우수 분반 / score1 이상 score2 미만 : 보통 분반 / score1 미만 : 부진 분반
				for(int j=i+1; j<uniqueList.size(); j++) {
					result = 1001;
					int score1 = uniqueList.get(i);
					int score2 = uniqueList.get(j);
//					System.out.println("score1 +score2::::::::"+score1 + " " +score2);
					
					int lowClass = cntSum[score1-1];
					if(lowClass < min || max < lowClass)  continue;
					int midClass = cntSum[score2-1]-cntSum[score1-1];
					if(midClass < min || max < midClass)  continue;
					int highClass = cntSum[cntSum.length-1]-cntSum[score2-1];
					if(highClass < min || max < highClass)  continue;
//					System.out.println("lowClass : " + lowClass + "midClass : " + midClass + "highClass : " + highClass);
//					System.out.println("highClass-lowClass " + (highClass-lowClass));
					result = Math.min(Math.abs(highClass-lowClass), result);
//					System.out.println(" result ::::::" + result);
				}
			}

			if(result ==1001) System.out.println("#"+tc+" "+"-1");
			else System.out.println("#"+tc+" "+result);
		} //tc for문
	}
}
