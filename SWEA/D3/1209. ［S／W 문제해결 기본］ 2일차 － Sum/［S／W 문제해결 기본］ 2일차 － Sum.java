import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			tc = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			// 배열 입력
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0;
			int max_sum = 0;
			
			// 가로 합
			for (int i = 0; i < arr.length; i++) { // 행 고정
				sum = 0;
				for (int j = 0; j < arr.length; j++) {
					sum += arr[i][j];
				}
				max_sum = Math.max(max_sum, sum);
			}
			
			// 세로 합
			for (int j = 0; j < arr.length; j++) {
				sum = 0;
				for (int i = 0; i < arr.length; i++) {
					sum += arr[i][j];
				}
				max_sum = Math.max(max_sum, sum);
			}
			
			// 우하향 대각선 합
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i==j) {
						sum += arr[i][j];
					}
				}
			}
			max_sum = Math.max(max_sum, sum);
			
			// 좌하향 대각선 합
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i+j == 99) {
						sum += arr[i][j];
					}
				}
			}
			max_sum = Math.max(max_sum, sum);
			
			System.out.printf("#%d %d\n", tc, max_sum);
			
		}
	}
}