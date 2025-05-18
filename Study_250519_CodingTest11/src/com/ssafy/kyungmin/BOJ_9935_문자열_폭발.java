import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935_문자열_폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 소문자, 대문자, 0~9
		// 1<문자열<1,000,000
		String str = br.readLine();
		// 1<폭발문자열<36
		String bomb = br.readLine();
		int length = bomb.length();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if (sb.length() >= length) {
				boolean isBomb = true;
				for (int j = 0; j < length; j++) {
					if (sb.charAt(sb.length() - length + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				if (isBomb) {
					sb.delete(sb.length() - length, sb.length());
				}
			}
		}

		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}
	}
}
