package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> numbering = new HashMap<String,Integer>();
		numbering.put("S", 0);
		numbering.put("D", 1);
		numbering.put("H", 2);
		numbering.put("C", 3);
		
		int T = Integer.parseInt(br.readLine());
		
		continuePoint:
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			boolean[][] check = new boolean[4][13];
			int[] cnt = {13,13,13,13};
			String input = br.readLine();
			input = input.replace("S", " S ").replace("D"," D ").replace("H"," H ").replace("C"," C ");
			
			StringTokenizer st = new StringTokenizer(input);
			
			while(st.hasMoreTokens()) {
				String tmp1 = st.nextToken();
				String tmp2 = st.nextToken();
				if(check[numbering.get(tmp1)][Integer.parseInt(tmp2)-1]) {
					System.out.println(sb.append("ERROR"));
					sb.setLength(0);
					continue continuePoint;
				}
				check[numbering.get(tmp1)][Integer.parseInt(tmp2)-1] = true;
				cnt[numbering.get(tmp1)]--;
			}
			for(int result : cnt) {
				sb.append(result).append(" ");
			}
			
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
