import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]>[] graph;
	static int[] vis;
//	static int min = Integer.MAX_VALUE;
	static int[] pass;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		vis = new int[N+1];
		
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			graph[start].add(new int[] {end, dis});
			graph[end].add(new int[] {start, dis});
		}
		
		st = new StringTokenizer(br.readLine());
		pass = new int[2];
		for (int i = 0; i < pass.length; i++) {
			pass[i] = Integer.parseInt(st.nextToken());
		}
				
		int ans1 = 0;
		int ans1First = dijkstra(1, pass[0]);
		int ans1Second = dijkstra(pass[0], pass[1]);
		int ans1Third = dijkstra(pass[1], N);
		
		if (ans1First == Integer.MAX_VALUE || ans1Second == Integer.MAX_VALUE || ans1Third == Integer.MAX_VALUE) {
			ans1 = -1;
		} else {
			ans1 = ans1First + ans1Second + ans1Third;
		}
		
		int ans2 = 0;
		int ans2First = dijkstra(1, pass[1]);
		int ans2Second = dijkstra(pass[1], pass[0]);
		int ans2Third = dijkstra(pass[0], N);
		
		if (ans2First == Integer.MAX_VALUE || ans2Second == Integer.MAX_VALUE || ans2Third == Integer.MAX_VALUE) {
			ans2 = -1;
		} else {
			ans2 = ans2First + ans2Second + ans2Third;
		}
		
		int sum = 0; 
		if (ans1 != -1 && ans2 != -1) {
			sum = Math.min(ans1, ans2);
		} else {
			sum = Math.max(ans1, ans2);
		}
		
		System.out.println(sum);	
	}
	public static int dijkstra(int start, int end) {

		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		};
		
		PriorityQueue<int[]> que = new PriorityQueue<>(com);
		
		que.add(new int[] {start,0});
		int[] vis = new int[graph.length];
		Arrays.fill(vis, Integer.MAX_VALUE);
		vis[start] = 0;
		
		while (!que.isEmpty()) {
			int temp[] = que.poll();
			
			if (graph[temp[0]] != null) {
				for (int i = 0; i < graph[temp[0]].size(); i++) {
					int cur = graph[temp[0]].get(i)[0];
					int distance = temp[1] + graph[temp[0]].get(i)[1];
					
					if (distance < vis[cur]) {
						vis[cur] = distance;
						que.add(new int[] {cur, distance});
					}
				}
			}
		}
		return vis[end];
	}
}