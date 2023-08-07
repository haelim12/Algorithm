import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			
			int sum = 0;
			
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 정렬
			for (int i = 0; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					int temp = arr[j];
					if (arr[j-1] < arr[j]) {
						arr[j] = arr[j-1];
						arr[j-1] = temp;
					}
				}
			}
			
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			
			int avg = Math.round((float) sum / (float) 8);
			
			System.out.printf("#%d %d\n", tc, avg);
		}
	}
}
