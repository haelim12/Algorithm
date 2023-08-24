import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N;
    static int M;
	static int[][] arr;
	static int[][][] vis;
	static int[] sword;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		vis = new int[N][M][2];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					sword = new int[] {i,j};
				}
			}
		}
		
			
		// 검을 찾지 않고 갔을 때 0
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {0,0,0});

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			if (r == N-1 && c == M-1) {
				break;
			}
			
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int ns = temp[2]; // 기존에 칼을 가지고 있었는지 여부 그대로 이어주기
				if (nr>=0 && nr<N && nc>=0 && nc<M) {
					// 이번에 칼을 찾았을 때
					if(nr == sword[0] && nc == sword[1]) {
						ns = 1;
						// visit[][][1] 배열의 다음 좌표(n)들에 기존 visit[][][0]+1을 넣음
						vis[nr][nc][ns] =vis[r][c][temp[2]]+1;
						q.add(new int[] {nr,nc,ns});
					}
					
					// 이전에 칼을 가지고 있었을 때
					else if (ns == 1 && vis[nr][nc][ns] == 0) {
						q.add(new int[] {nr,nc, ns});
						vis[nr][nc][ns] = vis[r][c][ns]+1;
					}

					// 이번에도 예전에도 칼이 없을 때
					else if (ns==0 && arr[nr][nc] ==0 && vis[nr][nc][ns] == 0) {
						vis[nr][nc][ns] = vis[r][c][ns]+1;
						q.add(new int[] {nr,nc,ns});
					}
				}
			}
		}

		int minTime = Math.max(vis[N-1][M-1][0], vis[N-1][M-1][1]);
		
		if (minTime > T || minTime ==0) {
			System.out.println("Fail");
		} else {
			System.out.println(minTime);
		}
		
	}
	
}