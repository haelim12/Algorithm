import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 인접행렬
			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjArr[start][end] = 1;                                                                                                                                                                                                                                                                                                                
				degree[end]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0)
					q.add(i);
			}
			
			System.out.printf("#%d ", tc);
			while (!q.isEmpty()) {
				int temp = q.poll();
				System.out.print(temp + " ");
				for (int i = 1; i < V + 1; i++) {
					if (adjArr[temp][i] == 1) {
						adjArr[temp][i] = 0; // 간선 제거
						degree[i]--; // 진입차수 감소

						if (degree[i] == 0)
							q.add(i);
					}
				}
			}
			System.out.println();
		}
	}
}