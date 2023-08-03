import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		// 수 받기
		int N = sc.nextInt();
		int[] arr = new int[N];
		int count = 1;
		List<String> list = new ArrayList<>();
		boolean check = true;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		stack.push(0);
		
		label : for (int i = 0; i < N; i++) {
			
			while(arr[i] != stack.peek()) {

				stack.push(count);
				count += 1;
				list.add("+");
				if (count > N+1) {
					check = false;
					break label;
				}
//				System.out.println(stack);
			}
			stack.pop();
			list.add("-");
			
		}
		
		if (check) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("NO");
		}
		
	}
}
