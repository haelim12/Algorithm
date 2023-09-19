import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N = 0;
	static int M = 0;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static boolean[][][] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		vis = new boolean[N][M][2];
		
		for (int i = 0; i < map.length; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		// 알거든요 ..?!..........
		bfs(0, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c,0,1}); // r, c, 벽 부순 count, 거리
		vis[r][c][0] = true;
		vis[r][c][1] = true;
		
		label : while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			int len = temp[3];
			if (temp[0] == N-1 && temp[1] == M-1) {
				min = Math.min(min, temp[3]);
				break label;
			}
			
			for (int d = 0; d < dr.length; d++) {
				int ni = temp[0] + dr[d];
				int nj = temp[1] + dc[d];
				int cnt = temp[2];
//				System.out.println(ni+" "+nj+" "+cnt);
				if (ni>=0 && ni<map.length && nj>=0 && nj<map[0].length) {
					if (!vis[ni][nj][cnt] && map[ni][nj]==0) {
						vis[ni][nj][cnt] = true;
						q.add(new int[] {ni, nj, cnt, len+1});
					}
					else if (map[ni][nj] == 1 && cnt == 0 && !vis[ni][nj][cnt+1]) {
						vis[ni][nj][cnt+1] = true;
						q.add(new int[] {ni, nj, cnt+1, len+1});
					}
				}
			}
		}
	}
}