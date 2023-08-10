import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			int r = 0;
			int c = 0;
			int count = 1;
			int dir = 0;// 우 하 좌 상
			
			arr[r][c] = count;
			
			while (count < N*N) {
				if (dir == 0) { // 우
					c++; // 1
					if (c >= N || arr[r][c] != 0) { // 1.2
						c--;
						r++;
						dir = 1;
					}
				} else if (dir == 1) { // 하
					r++;
					if (r>=N || arr[r][c] != 0) {
						r--;
						c--;
						dir = 2;
					}
				} else if (dir == 2) { // 좌
					c--; // 1
					if (c < 0 || arr[r][c] != 0) {
						c++;
						r--;
						dir = 3;	
					}
				} else { // 상
					r--;
					if (r < 0 || arr[r][c] != 0) {
						c++;
						r++;
						dir = 0;	
					}
				}
				arr[r][c] = ++count;
			}
			
			System.out.println("#"+tc);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}
}