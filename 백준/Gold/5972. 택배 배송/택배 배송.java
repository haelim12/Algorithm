import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]>[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new List[N+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int food = Integer.parseInt(st.nextToken());
			
			arr[start].add(new int[] {end, food});
			arr[end].add(new int[] {start, food});
		}
		
		bfs();
		System.out.println(min);
	}
	
	public static void bfs() {
		
		Comparator<int[]> ahyoung = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1]; //오름차순
			}
		};
		
		PriorityQueue<int[]> q = new PriorityQueue(ahyoung);
		q.add(new int[] {1, 0});
		int[] vis = new int[arr.length];
		Arrays.fill(vis, Integer.MAX_VALUE);
		vis[1] = 0;
		
		while (!q.isEmpty()) {
			int[] start = q.poll();
			
//			System.out.println(Arrays.toString(start));
			
			for (int i = 0; i < arr[start[0]].size(); i++) {
				int cur = arr[start[0]].get(i)[0];
				int dis = start[1] + arr[start[0]].get(i)[1];
				if (vis[cur] > dis) {
					vis[cur] = dis;
					q.add(new int[] {cur, dis});
				}
			}	
		}// 침흘리는 김아영 kill
		
		min = Math.min(min, vis[arr.length-1]);
	}
}