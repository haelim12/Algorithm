import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Queue<int[]> q = new LinkedList();
		boolean[][] visited = new boolean[n][m];
		int count = 1;
		int pic = 0;
		int max_count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count = 1;
				if (arr[i][j] == 1 && !visited[i][j]) {
					q.offer(new int[] {i,j});
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] temp = q.poll();
//						System.out.println(Arrays.toString(temp));
						for (int k = 0; k < 4; k++) {
							int ni = temp[0] + dr[k];
							int nj = temp[1] + dc[k];
							if (ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj] == 1 && !visited[ni][nj]) {
								q.offer(new int[] {ni,nj});
								visited[ni][nj] = true;
								count++;
							}
						}
					}
					if (count>=1) {
						pic++;
					}
				}
				max_count = Math.max(max_count, count);
			}
		}
		System.out.println(pic);
		if (pic == 0) {
			System.out.println(0);
		}else {
		System.out.println(max_count);
		}
	}
}