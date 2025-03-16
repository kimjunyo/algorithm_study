package etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class word빈도수 {
		public static void main(String[] args) throws IOException {
			Map<String, Integer> check = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader("./word.txt"));
			String line;

	        while ((line = br.readLine()) != null) { 
	        	line = line.replaceAll("[.,:]","");
	            StringTokenizer st = new StringTokenizer(line);
	            
	            while (st.hasMoreTokens()) {
	            	String input = st.nextToken().toLowerCase();
	            	check.put(input, check.getOrDefault(input, 0)+1);
	            }
	        }
	        
	        List<Map.Entry<String, Integer>> list = new ArrayList<>(check.entrySet());
	        list.sort(new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return o2.getValue()-o1.getValue(); //내림차순
				}
			});
	        
	        System.out.println("단어 \t 빈도수");
	        System.out.println("-".repeat(15));
	        for(Map.Entry<String, Integer> item : list) {
	        	System.out.println(item.getKey() + "\t" + item.getValue());
	        }
	}
}
