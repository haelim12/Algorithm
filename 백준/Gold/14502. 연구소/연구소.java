import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<int[]> virus = new ArrayList<>();
	static List<int[]> list0 = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 이중 포문 말고 재귀로 해주세요. 코드 구려요 
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
				if (map[i][j] == 0) {
					list0.add(new int[] {i, j});
				}
			}
		}
		
		boolean[] vis = new boolean[list0.size()];
		int[] change = new int[3]; // 벽으로 바꿔줄 배열
		choose(0, 0, vis, change);
		
		System.out.println(max);
	}
	
	public static void choose(int count, int index, boolean[] vis, int[] change) {
		if (count == 3) { // 3개 골랐으면 그 지점 1로 바꾸고 2 바꿔주고 개수세기.
			int[][] newMap = new int[N][M];
			
			for (int i = 0; i < newMap.length; i++) {
				newMap[i] = map[i].clone();
			}
			
			for (int i = 0; i < change.length; i++) {
				newMap[list0.get(change[i])[0]][list0.get(change[i])[1]] = 1;
			}
			spread(newMap);
			
			int virusCnt = 0;
			for (int i = 0; i < newMap.length; i++) {
				for (int j = 0; j < newMap[0].length; j++) {
					if (newMap[i][j] == 0) {
						virusCnt += 1;
					}
				}
			}
			max = Math.max(max, virusCnt);
			return;
		}
		
		for (int j = index; j < list0.size(); j++) {
			if (!vis[j]) {
				vis[j] = true;
				change[count] = j;
				choose(count+1, j, vis, change);
				vis[j] = false;
			}
		}
	}
	
	public static void spread(int[][] newMap) {
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				if (newMap[i][j] == 2) {
					bfs(i,j, newMap);
				}
			}
		}
	}
	
	public static void bfs(int i, int j, int[][] newMap) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int d = 0; d < dr.length; d++) {
				int ni = temp[0] + dr[d];
				int nj = temp[1] + dc[d];
				
				if (ni>=0 && ni<N && nj>=0 && nj<M && newMap[ni][nj] == 0) {
					newMap[ni][nj] = 2;
					q.add(new int[] {ni, nj});
				}
			}
		}
	}
}
