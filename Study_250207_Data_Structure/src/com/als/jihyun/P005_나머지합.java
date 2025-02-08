import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] numArr = new long[Integer.parseInt(st.nextToken())+1];
		int M = Integer.parseInt(st.nextToken());
		
		long[] sumArr = new long[numArr.length];
		long[] reArr = new long[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<numArr.length; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			sumArr[i] = numArr[i] + sumArr[i-1];
			reArr[(int)(sumArr[i]%M)]++;
		}
		
		long count = reArr[0];
		for(long remain : reArr) {
			count += remain * (remain -1) /2;
		}
		System.out.println(count);
	}
}