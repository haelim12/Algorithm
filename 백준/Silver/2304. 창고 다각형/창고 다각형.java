import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[1001];
		
		int minIdx = Integer.MAX_VALUE;
		int maxIdx = Integer.MIN_VALUE;
		
		int highestIdx = Integer.MIN_VALUE;
		int highest = Integer.MIN_VALUE;
		
		for (int n = 0; n < N; n++) {
			int i = sc.nextInt();
			arr[i] = sc.nextInt();
			minIdx = Math.min(minIdx, i);
			maxIdx = Math.max(maxIdx, i);
			highest = Math.max(highest, arr[i]);
			if (arr[i] == highest) {
				highestIdx = i;
			}
		}

		int sum = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		stack.add(arr[minIdx]);
		for (int i = minIdx; i < highestIdx + 1; i++) {
			if (stack.peek() < arr[i]) {
				stack.add(arr[i]);
			} 
			sum += stack.peek();
		}
		
		stack = new Stack<>();
		stack.add(arr[maxIdx]);
		for (int i = maxIdx; i > highestIdx; i--) {
			if (stack.peek() < arr[i]) {
				stack.add(arr[i]);
			} 
			sum += stack.peek();
		}
		
		System.out.println(sum);
		
	}
}