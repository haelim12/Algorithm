import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		map = new int[N][3];
		dp = new int[N][3];
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		int min = Math.min(recursion(N-1, 0), Math.min(recursion(N-1, 1), recursion(N-1, 2)));
		
		System.out.println(min);
	}
	
	public static int recursion(int i, int color) {
		if(dp[i][color] == 0) {
			if (color == 0) {
				dp[i][color] = Math.min(recursion(i-1, 1), recursion(i-1, 2)) + map[i][color];
			} else if (color == 1) {
				dp[i][color] = Math.min(recursion(i-1, 0), recursion(i-1, 2)) + map[i][color];
			} else {
				dp[i][color] = Math.min(recursion(i-1, 0), recursion(i-1, 1)) + map[i][color];
			}
			
		}
		
		return dp[i][color];
	}
}