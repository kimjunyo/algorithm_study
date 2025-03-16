package etc;

import java.net.MalformedURLException;
import java.net.URL;

public class Test01_URL_일타싸피_네트워크 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.saramin.co.kr/zf_user/tools/character-counter");
			System.out.println("protocal : " + url.getProtocol());
			System.out.println("host : " + url.getHost());
			System.out.println("port : " + url.getPort());
			System.out.println("path : " + url.getPath());
			System.out.println("query : " + url.getQuery());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
