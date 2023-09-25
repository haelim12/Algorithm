import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        main : for (int t = 0; t < T; t++) {
			String met = br.readLine();
			char[] mArr = met.toCharArray();
			
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			str = str.replace("[", "");
			str = str.replace("]", "");
			String[] strArr = str.split(",");

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < strArr.length; i++) {
				if(N > 0) list.add(Integer.parseInt(strArr[i]));
			}
			
			int j = 0;
			for (int i = 0; i < mArr.length; i++) {
				if(mArr[i] == 'R') {
					if(j == 0) {
						j = list.size() - 1;
					} else {
						j = 0;
					}
				} else {
					if(!list.isEmpty()) {
						int x = list.remove(j);
						if(j != 0) j = list.size()-1;
					} else {
						sb.append("error").append('\n');
						continue main;
					}
				}
			}
			
			sb.append("[");
			
			if(list.isEmpty()) {
				sb.append(" ");
			} else if(j > 0) {
				for (; j >= 0; j--) {
					sb.append(list.get(j)).append(",");
				}
			} else {
				for (; j < list.size(); j++) {
					sb.append(list.get(j)).append(",");
				}
			}
			
			sb.deleteCharAt(sb.length()-1).append("]").append('\n');
			
		}
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}