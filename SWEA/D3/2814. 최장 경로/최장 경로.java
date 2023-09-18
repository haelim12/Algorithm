import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, M;
	static List<Integer>[] graph;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			graph = new List[N+1];
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				graph[start].add(end);
				graph[end].add(start);
			}
			
			for (int i = 1; i < graph.length; i++) {
				boolean[] vis = new boolean[N+1]; 
				vis[i] = true;
				dfs(i, vis, 1);
			}
			
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	public static void dfs(int start, boolean[] vis, int count) {
		for (int j = 0; j < graph[start].size(); j++) {
			int temp = graph[start].get(j);
			if (!vis[temp]) {
				vis[temp] = true;
				dfs(temp, vis, count+1);
				vis[temp] = false;
			}
		}
		max = Math.max(max, count);
		// 왜 안 끝내고 난리?
	}
}