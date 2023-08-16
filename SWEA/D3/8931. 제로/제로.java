import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
//				System.out.println(num);
				if (num != 0) {
					stack.push(num);
//					System.out.println(stack.peek());
				} else {
					stack.pop();
				}
			}
//			System.out.println(stack.size());

			int sum = 0;
			while (!stack.isEmpty()) {
				sum+= stack.pop();
			}
			System.out.printf("#%d %d\n", tc, sum);
			
		}
	}
}