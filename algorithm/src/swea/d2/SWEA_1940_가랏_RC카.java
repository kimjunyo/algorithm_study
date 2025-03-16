package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940_가랏_RC카  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int speed = 0, distance =0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if(command==1){ //가속
					speed += Integer.parseInt(st.nextToken());
					distance += speed;
				}else if(command==2) { //감속
					speed -= Integer.parseInt(st.nextToken());
					if(speed<0) speed = 0;
					else distance += speed;
				}else { //유지
					distance += speed;
				}
			}
			System.out.println("#" + tc + " " +distance);
		}
	}
}