import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int n = sc.nextInt();
//		int m = sc.nextInt();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		int dis = 0;
		int starti = 0;
		int startj = 0;
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
				if (arr[i][j] == 2) {
					starti = i;
					startj = j;
				}
			}
		}
		
		bfs(starti, startj, dis);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]==0) {
					sb.append(arr[i][j]).append(" ");
				}else {
					sb.append(arr[i][j]-2).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int starti, int startj, int dis) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {starti, startj});

		while (!queue.isEmpty()) {

			int[] idx = queue.poll();

			int i = idx[0];
			int j = idx[1];

			for (int d = 0; d < dr.length; d++) {
				int ni = i + dr[d];
				int nj = j + dc[d];
				if (ni >= 0 && ni < arr.length && nj >= 0 && nj < arr[0].length && arr[ni][nj] == 1) {
					arr[ni][nj] = arr[i][j] + 1;
					queue.offer(new int[] { ni, nj });
				}
			}
		}
	}
}