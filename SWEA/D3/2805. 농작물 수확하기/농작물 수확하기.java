import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			sc.nextLine();
			for (int i = 0; i < map.length; i++) {
				String[] str = sc.nextLine().split("");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			int sum = 0;
			int start = N/2; // 2
			int end = N/2; // 2
			
			for (int i = 0; i < map.length; i++) {
				for (int j = start; j <= end; j++) {
					sum += map[i][j];
				}
				if (i<N/2) {
					start -= 1;
					end += 1;
				} else {
					start += 1;
					end -= 1;
				}
//				System.out.println(start + " " + end + " " + sum);
			}
//			System.out.println();
			System.out.printf("#%d %d\n", tc, sum);
			
		}
	}
}