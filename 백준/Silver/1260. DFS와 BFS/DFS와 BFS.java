import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> queue  = new LinkedList<>();
	static boolean[] vis;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt(); // start
		
		arr = new int[N+1][N+1];
		vis = new boolean[N+1];
		
		
		for (int m = 0; m < M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			arr[i][j] = arr[j][i] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		vis = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
		
	}
	
	public static void dfs(int start) {
		vis[start] = true;
		sb.append(start).append(" ");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[start][i] == 1 && !vis[i]) {
				dfs(i);
			}
		}
//		return;
	}
	
	public static void bfs(int start) {
		queue.add(start);
		vis[start] = true;
		
		while (!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start).append(" ");
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[start][i] == 1 && !vis[i]) {
					queue.add(i);
					vis[i] = true;
				}
			}
		}
		return;
	}
}