import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, B;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 직원수
			B = sc.nextInt(); // 탑 높이
			
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = 0;
			min = Integer.MAX_VALUE;
			recursion(0, sum);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	public static void recursion(int index, int sum) {
		
		if (sum >= B) {
			min = Math.min(min, Math.abs(sum-B));
			return;
		}
		
		if (index == N) {
			return;
		}

		recursion(index+1, sum+arr[index]);
		recursion(index+1, sum);
	}
}