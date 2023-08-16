import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {

			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			int cut = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push('(');
				} else {
					if (str.charAt(i-1) == '(') {
						stack.pop();
						cut += stack.size();
					} else {
						stack.pop();
						cut++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cut);
		}
	}
}