import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		sb = new StringBuilder();
		
		recursion(0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int n) {
		if (n == M) {
			
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			arr[n] = i;
			recursion(n+1);
		}
		
	}
}