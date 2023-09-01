import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt(); // 내맘이라고 지금 몇 번 말해
		int[] arr = new int[M];
		sb = new StringBuilder();
		recursion(0, N, arr, 1);
		
		System.out.println(sb);
		
	}
	public static void recursion(int idx, int N, int[] arr, int num) {
		
		if (idx == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = num; i <= N; i++) {
			arr[idx] = i;
			recursion(idx+1, N, arr, i);
		}
	}
}