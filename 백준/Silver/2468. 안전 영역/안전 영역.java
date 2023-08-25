import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] newMap;
	static boolean[][] vis;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int start;
	static int count = 0;
	static int land = 0;
	static int rain;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N][N];
		vis = new boolean[N][N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		rain = 0;
		int max_land = Integer.MIN_VALUE;
		while (rain < max) {
			vis = new boolean[N][N];
			land = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] > rain && !vis[i][j]) {
						vis[i][j] = true;
						land++;
						bfs(i,j);
					}
				}
			}
//			System.out.println(rain + " " + land);
			max_land = Math.max(max_land, land);
			rain++;
		}
		
		System.out.println(max_land);
	
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
				
				if (ni >=0 && ni < map.length && nj >= 0 && nj < map[0].length && map[ni][nj] > rain && !vis[ni][nj]) {
                    q.offer(new int[] {ni,nj});
                    vis[ni][nj] = true;
                }
			}
		}
	}
}