import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, M;
	static int[][] graph;
	static int count = 0;
	static List<String> triangle;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			count = 0;
			triangle = new ArrayList<>();
			graph = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				graph[x][y] = graph[y][x] = 1;
			}
			
			int count = 0;
			for (int i = 1; i < graph.length; i++) {
				for (int j = i+1; j < graph.length; j++) {
					if (graph[i][j] == 0) {
						continue;
					}
					for (int k = j+1; k < graph.length; k++) {
						if (graph[j][k] == 0) {
							continue;
						}
						if (graph[k][i] == 0) {
							continue;
						}
						count++;
					}
					
				}
				
			}
			System.out.printf("#%d %d\n", tc, count);
			
		}
	}
}