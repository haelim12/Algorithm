import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int word = 0;
			int len = 0;
			
			// 가로 확인
			for (int i = 0; i < N; i++) { // 행 고정
				len = 0;
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 0) {
						if (len == K) {
							word++;
						}
						len = 0;
					} else {
						len++;	
					}
				}
				if (len == K) {
					word++;
				}
			}
			
			// 세로 확인
			for (int j = 0; j < N; j++) { // 열 고정
				len = 0;
				for (int i = 0; i < N; i++) {
					if(arr[i][j] == 0) {
						if (len == K) {
							word++;
						}
						len = 0;
					} else {
						len++;	
					}
				}
				if (len == K) {
					word++;
				}
			}
			System.out.printf("#%d %d\n", tc, word);
		}
	}
}