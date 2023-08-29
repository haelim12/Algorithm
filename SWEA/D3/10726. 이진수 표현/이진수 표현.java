import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				if (M % 2 == 1) {
					stack.add(1);
				} else {
					stack.add(0);
				}
//				System.out.println(stack.peek());
				M = M/2;
			}
			
			boolean check = true;
			while (!stack.isEmpty()) {
				int temp = stack.pop();
				if (temp == 0) {
					check = false;
				}
			}
			
			if (check) {
				System.out.printf("#%d ON\n", tc);
			} else {
				System.out.printf("#%d OFF\n", tc);
			}
		}
	}
}