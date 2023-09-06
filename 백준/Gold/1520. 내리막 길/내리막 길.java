import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		
		dp[0][0] = 1;
		System.out.println(recursion(N-1,M-1));
		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
		}
	}
	
	public static int recursion(int r, int c) {
		if (dp[r][c] != -1) {
			return dp[r][c];
		}
		
		int temp = 0;
		for (int d = 0; d < dc.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (checkBound(nr,nc) && map[nr][nc]> map[r][c]) {
				temp += recursion(nr,nc);
			}
		}
		// 이해했다 !.. 한 .... 79...
		dp[r][c] = temp;
		return dp[r][c];
	}
	public static boolean checkBound(int r, int c) {
		if (r>=0 && r<map.length && c>=0 && c<map[0].length) {
			return true;
		}
		return false; // 와 멋지다 ........!
	}
}