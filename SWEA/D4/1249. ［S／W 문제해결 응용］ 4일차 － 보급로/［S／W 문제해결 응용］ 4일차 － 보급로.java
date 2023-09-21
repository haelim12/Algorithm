import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int[][] map;
	static int[][] vis;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			vis = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				String[] st = br.readLine().split("");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st[j]);
					vis[i][j] = Integer.MAX_VALUE;
				}
			}

			vis[0][0] = 0;
			dijkstra(0,0);
			System.out.printf("#%d %d\n", tc, vis[N-1][N-1]);
		}
	}
	
	public static void dijkstra(int r, int c) {
		// 인덱스 값, 최단경로 거기까지의 최단경로
		Comparator<int[]> com = new Comparator<int[]>() {//ㅡㅡ
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]- o2[2];
			}
		};
		
		PriorityQueue<int[]> q = new PriorityQueue<>(com);
		q.add(new int[] {r,c,vis[r][c]});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
//			temp[0] = r;
//			temp[1] = c; // 내맘이야 ㅡㅡ
			for (int d = 0; d < dc.length; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if (nr>=0 && nr<map.length && nc>=0 && nc<map.length) {
					int current = temp[2] + map[nr][nc];
					if (vis[nr][nc] > current) {
						vis[nr][nc] = current;
						q.add(new int[] {nr, nc, current});
					}
				}
			}
		}
		// 이거 언제 완성되는거야??
	 	// 내년쯤에는 되나? 몰라요
	}
}