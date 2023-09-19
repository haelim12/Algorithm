import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static String[][] maze;
	static boolean[][] vis;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <=10; tc++) {
			int test = Integer.parseInt(br.readLine());
			
			maze = new String[16][16];
			int[] start = new int[1];
			
			for (int i = 0; i < maze.length; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < maze[0].length; j++) {
					maze[i][j] = temp[j];
					if (maze[i][j].equals("2")) {
						start = new int[] {i,j};
					}
				}
			}

			vis = new boolean[16][16];
			check = false;
			bfs(start[0], start[1]);
			
			if (check) {
				System.out.printf("#%d 1\n", tc);
			} else {
				System.out.printf("#%d 0\n", tc);
			}
			
		}
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		vis[i][j] = true;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (maze[temp[0]][temp[1]].equals("3")) {
				check = true;
				return;
			}
			
			for (int d = 0; d < dc.length; d++) {
				int ni = temp[0] + dr[d];
				int nj = temp[1] + dc[d];
				
				if (ni>=0 && ni<maze.length && nj>=0 && nj<maze.length && !vis[ni][nj] && (maze[ni][nj].equals("0")||maze[ni][nj].equals("3"))) {
					q.offer(new int[] {ni, nj});
					vis[ni][nj] = true;
				}
			}
		}
		
		
	}
}