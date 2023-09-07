import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static int[] vis;
	static int X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < vis.length; i++) {
			if (vis[i] == K) {
				sb.append(i).append("\n");
			}
		}
		
		if (sb.length() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(sb);
		}
		
	}
	
	public static void bfs() {
		
		Comparator<int[]> com = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		}; 
		
		PriorityQueue<int[]> que = new PriorityQueue<>(com);
		vis = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			vis[i] = Integer.MAX_VALUE;
		}
		vis[X] = 0;
		
		que.add(new int[] {X,0});
		
		while (!que.isEmpty()) {
			int[] start = que.poll();
			for (int i = 0; i < graph[start[0]].size(); i++) {
				int cur = graph[start[0]].get(i);
				int dis = start[1] + 1;
				if (vis[cur] > dis) {
					vis[cur] = dis;
					que.add(new int[] {cur, dis});
				}
			}
		}	
	}
}