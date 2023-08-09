import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int flies = 0;
			int max_flies = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					flies = 0;
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							if (r+i < N && c+j < N) {
								flies += arr[r+i][c+j];
							}
						}
					}
					max_flies = Math.max(max_flies, flies);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max_flies);
		}
	}
}