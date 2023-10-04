import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] arr = st.nextToken().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				sb.append(arr[i]);
			} else if (arr[i] == '(') {
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else { // 연산 기호일 경우
				// 스택에 들어있는 연산 기호 우선순위가 더 클 경우 pop
				while (!stack.isEmpty() && check(stack.peek()) >= check(arr[i])) {
					sb.append(stack.pop());
				}
				stack.push(arr[i]);
			}
		}
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
	public static int check(char c) {
		if (c == '+' || c == '-') {
			return 1; // +, - 일 때
		} else if (c == '*' || c == '/') {
			return 2; // *, / 일 때
		} else { // 괄호 일 때
			return -1;
		}
	}
		
}