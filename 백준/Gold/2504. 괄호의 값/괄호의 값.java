import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		
		String str = sc.nextLine();
		
		int sum = 1;
		int result = 0;
		
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) { 
			
			case '(':
				stack.push('(');
				sum *= 2;
				break;
				
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					System.out.println(0); 						
					return;
				}
				if (str.charAt(i - 1) == '(')
					result += sum;
				stack.pop();
				sum /= 2;
				break;
			
			case '[':
				stack.push('[');
				sum *= 3;
				break;
				
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					System.out.println(0); 						
					return;
				}
				if (str.charAt(i - 1) == '[')
					result += sum;
				stack.pop();
				sum /= 3;
				break;
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}
}