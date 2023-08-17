import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] vis = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // start
		int K = sc.nextInt(); // end
		int count = 0;
		
		
		System.out.println(bfs(N, K, count));
	}
	
	public static int bfs(int start, int end, int count) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			count++;
			Queue<Integer> q2 = new LinkedList<Integer>();
			while (!queue.isEmpty()) {
				start = queue.poll();
				if (start == end) {
					q2 = new LinkedList<Integer>();
					break;
				}
				
				if (start-1 >= 0 && start-1 < vis.length && !vis[start-1]) {
					q2.add(start-1);
					vis[start-1] = true;
				}
				if (start+1 >= 0 && start+1 < vis.length &&!vis[start+1]) {
					q2.add(start+1);
					vis[start+1] = true;
				}
				if (start*2 >= 0 && start*2 < vis.length &&!vis[start*2]) {
					q2.add(start*2);
					vis[start*2] = true;
				}
			}
			queue = q2;
			
//			System.out.println(start + " 왜안나와");
		}
		return count-1;
	}
}