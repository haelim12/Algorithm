import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Main {
	static int[][] arr;
	static int[][] vis;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N+1][N+1];
		vis = new int[N+1][N+1];
		count = 0;
		
		for (int m = 0; m < M; m++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			arr[r][c] = arr[c][r] = 1;
		}
		
		for (int i = 1; i < arr.length; i++) {
			count = 0;
			bfs(i, count);
		}
		
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 1; i < vis.length; i++) {
			int sum = 0;
			for (int j = 1; j < vis.length; j++) {
				if (i != j) {
					sum += vis[i][j];
				}
			}

			if (sum < min) {
				min = sum;
				minIdx = i;
			}
		}

		System.out.println(minIdx);
		
	}
	
	public static void bfs(int start, int count) {
		
		q.add(start);
		vis[start][start] = 1;
		count = 0;
		while (!q.isEmpty()) {
			Queue<Integer> tempq = new LinkedList<>();
//			count = 0;
			count++;
			while (!q.isEmpty()) {
				int temp = q.poll();
				for (int j = 1; j < arr.length; j++) {
					if (temp != j && vis[start][j]== 0 && arr[temp][j] == 1) {
						tempq.add(j);
						vis[start][j] = count;
//						System.out.println(temp+ " "  + j + " " + count);
					}
				}
			}
			q = tempq;
		}
//		for (int i = 0; i < vis.length; i++) {
//			System.out.println(Arrays.toString(vis[i]));
//		}
//		System.out.println();
	}
}