import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int tc1 = sc.nextInt();
			int[][] ladder = new int[100][100];
			// 사다리 받기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			int col = 0;
			for (int j = 0; j < 100; j++) {
				if (ladder[99][j] == 2) {
					col = j;
					break;
				}
			}
//			System.out.println(col);
			// 2에서부터 시작
			int idx = 99;
			int dir = 0;
			while (idx > 0) {
				
				// 왼쪽 끝
				if (dir == 1 && col-1 >= 0 && ladder[idx][col-1] == 0) {
					idx--;
					dir = 0;
//					System.out.println("왼쪽 끝 왔나?");
					continue;
				}
				// 오른쪽 끝
				if (dir == 2 && col+1 <100 && ladder[idx][col+1] == 0) {
					idx--;
					dir = 0;
//					System.out.println("오른쪽 끝 왔나?");
					continue;
				}
				// 왼쪽 고
				if (col-1 >= 0 && ladder[idx][col-1] == 1 && dir != 2) {
					dir = 1;//왼쪽
					col--;
//					System.out.println("왼쪽으로 가고 있나?");
					continue;
				}
				// 오른쪽 고
				if (col+1 <100 && ladder[idx][col+1] == 1 && dir != 1) {
					dir = 2; //오른쪽
					col++;
//					System.out.println("오른쪽으로 가고 있나?");
					continue;
				}
				// 위로 ...
				if (true) {
					idx--;
					dir = 0;
//					System.out.println("되고있나?");
				}
			}
			
			System.out.printf("#%d %d\n", tc,col);
		}
	}
}