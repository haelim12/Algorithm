import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] map = new boolean[101][101];
		
		int N = sc.nextInt();

		
		for (int n = 0; n < N; n++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for (int i = c; i < c+10; i++) {
				for (int j = r; j < r+10; j++) {
					map[i][j] = true;
				}
			}
		}
		int count = 0;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (map[i][j]) {
					for (int d = 0; d < dc.length; d++) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						
						if (!map[ni][nj]) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}