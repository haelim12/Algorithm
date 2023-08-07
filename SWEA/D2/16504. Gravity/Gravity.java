import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] box = new int[N];
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				box[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = i+1; j < N; j++) {
					if (box[i] <= box[j]) {
						cnt += 1;
					}
				}
				
				max = Math.max(max, N-cnt-i-1);
			}
			
			System.out.println("#" + tc + " " + max);
			
		}
	}
}
