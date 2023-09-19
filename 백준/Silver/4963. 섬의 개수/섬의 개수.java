import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static int start;
	static int count = 0;
	static int land;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 while (true) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			if (N==0 && M==0) {
				break;
			}
			map = new int[N][M];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			vis = new boolean[N][M];
			land = 0;
					
			for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map[0].length; j++) {
	                if (map[i][j] == 1 && !vis[i][j]) {
	                    vis[i][j] = true;
	                    land++;
	                    bfs(i, j);
	                }
	            }
	        }
			System.out.println(land);
		}
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for (int d = 0; d < dr.length; d++) {
				int ni = r + dr[d];
				int nj = c + dc[d];
				
				if (ni>=0 && ni < map.length && nj >= 0 && nj < map[0].length && map[ni][nj] == 1 && !vis[ni][nj]) {
                    q.offer(new int[] {ni,nj});
                    vis[ni][nj] = true;
                }
			}
		}
	}
}