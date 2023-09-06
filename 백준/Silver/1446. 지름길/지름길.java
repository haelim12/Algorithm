import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<int[]>[] arr;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		arr = new List[D+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			if (start>=arr.length) {
				continue;
			}
			
			if (arr[start] == null) {
				arr[start] = new ArrayList();
			} 
			arr[start].add(new int[] {end, dis});
		}
		bfs();
		
		System.out.println(min);
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] start = q.poll();
			if (start[0] == arr.length-1) {
				min = Math.min(min, start[1]);
				continue;
			}
			if (arr[start[0]] != null) {
				for (int i = 0; i < arr[start[0]].size(); i++) {
					if (arr[start[0]].get(i)[0] < arr.length) {
						q.add(new int[] {arr[start[0]].get(i)[0], arr[start[0]].get(i)[1]+start[1]});
					}
				}
			}
			q.add(new int[] {start[0]+1, start[1]+1});
		}
	}
}