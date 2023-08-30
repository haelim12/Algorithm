import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int L = 0;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			L = sc.nextInt();
			max = Integer.MIN_VALUE;
			map = new int[N][2];
			for (int i = 0; i < map.length; i++) {
				map[i][0] = sc.nextInt(); // 점수
				map[i][1] = sc.nextInt(); // 칼로리
			}
			
			List<Integer> cal = new ArrayList<>();
			int calsum = 0;
			int score = 0;
			dfs(0, calsum, cal);
			System.out.println("#"+tc+" "+max);
		}
	}
	public static void dfs(int index, int calsum, List<Integer> cal) {
		if (calsum >= L) {
			if (calsum == L) {
				int score = 0;
				for (int i = 0; i < cal.size(); i++) {
					score += map[cal.get(i)][0];
				}
				max = Math.max(max, score);
			} 
			else {
				int score = 0;
				for (int i = 0; i < cal.size()-1; i++) {
					score += map[cal.get(i)][0];
				}
				max = Math.max(max, score);
			}
			return;
		} 
		if (index == map.length) {
			int score = 0;
			for (int i = 0; i < cal.size(); i++) {
				score += map[cal.get(i)][0];
			}
			max = Math.max(max, score);
			return;
		}
		
		cal.add(index);
		calsum += map[index][1];
		dfs(index+1, calsum, cal);
		calsum -= map[index][1];
		cal.remove(cal.size()-1);
		
		dfs(index+1, calsum, cal);
	}
}