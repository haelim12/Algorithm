import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> belt; // 내구도, 로봇 유무 (있으면 1, 없으면 0)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		belt = new ArrayList<>();
		for (int i = 0; i < N*2; i++) {
			belt.add(new int[] {Integer.parseInt(st.nextToken()), 0});
		}
		
		 // 내구도가 0인 칸 개수
		int count = 0;
		
		while (true) {
			count++;
			int zeroCnt = 0;
			
			// 1. 한 칸 회전시키기 (마지막칸 -> 맨 앞으로)
			int[] last = belt.get(belt.size()-1);
	        belt.remove(belt.size()-1);
	        belt.add(0, last);
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
			for (int i = N-1; i >= 0; i--) {
				if (belt.get(i)[1] == 1) { // 칸에 로봇이 있을 때
					if (i == N-1) { // 마지막 칸일 때
						belt.get(i)[1] = 0; // 로봇 내려주기
					} 
					else if (belt.get(i+1)[0] >= 1 && belt.get(i+1)[1]==0) { // 가야하는 곳 내구도가 1이상일 때
						if (i+1 == N-1) {
							belt.get(i)[1] = 0;
							belt.get(i+1)[0]--;
							continue;
						}
						belt.get(i+1)[0]--;
						belt.get(i+1)[1] = 1;
						belt.get(i)[1] = 0;
					}
				}
			}
			
			// 3. 컨베이어 벨트 1번 칸의 내구도가 0이 아닐 때 -> 로봇 올린다
			if (belt.get(0)[0] > 0 && belt.get(0)[1] == 0 ) {
				belt.get(0)[1] = 1; // 로봇 올림~
				belt.get(0)[0]--;
			}
			
			
			// 4. 내구도 0인 칸 개수 세기
			for (int i = 0; i < belt.size(); i++) {
				if (belt.get(i)[0] == 0) {
					zeroCnt++;
				}
			}
			
			if (zeroCnt >= K) {
				break;
			}
		}
		
		System.out.println(count);
	}
}