import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 손님 수
			int M = Integer.parseInt(st.nextToken()); // 걸리는 시간
			int K = Integer.parseInt(st.nextToken()); // 그동안 만들어지는 붕어빵 수
			
			int[] guest = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				guest[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean possible = true;
			Arrays.sort(guest);
			
			int[] guestTime = new int[guest[guest.length-1]+1];
			for (int i = 0; i < guest.length; i++) {
				guestTime[guest[i]]++;
			}
			
			int time = 0;
			int bread = 0;
			
			for (int i = 0; i < guestTime.length; i++) {
				if (i!=0 && i%M==0) {
					bread += K;
				}
				
				if (bread>=guestTime[i]) {
					bread -= guestTime[i];
				} else {
					possible = false;
					break;
				}
			}

			if (possible) {
				sb.append("Possible\n");
			} else {
				sb.append("Impossible\n");
			}
		}
		System.out.println(sb);
	}
}