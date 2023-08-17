import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		sc.nextLine();
		
		Map<Integer, String> map = new HashMap<>(); // 이름이 value
		Map<String, Integer> map2 = new HashMap<>(); // 키가 value
		String[][] monster = new String[N][2];
		
		for (int i = 0; i < N; i++) {
//			monster[i][0] = Integer.toString(i+1);
//			monster[i][1] = br.readLine();
			String temp = br.readLine();
			map.put(i+1, temp);
			map2.put(temp, i+1);
		}
		
		for (int m = 0; m < M; m++) {
//			String find = sc.nextLine();
			String find = br.readLine();
			boolean isnum = true;
			char temp = 0;
			for (int i = 0; i < find.length(); i++) {
				temp = find.charAt(i);
			}
			if (Character.isDigit(temp) == false) { // 숫자가 아닌 경우
				isnum = false;
			}
			
//			int ans_i = 0;
//			int ans_j = 0;
			if (!isnum) { // 숫자가 아닌 경우 [1]에서 찾기
				System.out.println(map2.get(find));
				
			} else {
				int num = Integer.parseInt(find);
				System.out.println(map.get(num));
			}
		}
	}
}