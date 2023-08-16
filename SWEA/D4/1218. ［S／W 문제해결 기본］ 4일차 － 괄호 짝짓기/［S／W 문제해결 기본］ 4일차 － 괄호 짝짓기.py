import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			boolean check = true;
			sc.nextLine();
			String str = sc.nextLine();
			label : for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
//					System.out.println(str.charAt(i));
					stack.push('(');
					
				} else if (str.charAt(i) == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						check = false;
					}
				} else if (str.charAt(i) == '[') {
					stack.push('[');
				} else if (str.charAt(i) == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						check = false;
					}
				} else if (str.charAt(i) == '{'){
					stack.push('{');
				} else if (str.charAt(i) == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						check = false;
					}
				} else if (str.charAt(i) == '<') {
					stack.push('<');
				} else {
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						check = false;
					}
				}
			}
			
			if (stack.isEmpty() && check) {
				System.out.printf("#%d 1\n", tc);
			} else {
				System.out.printf("#%d 0\n", tc);
			}
		}
		
		
	}
}