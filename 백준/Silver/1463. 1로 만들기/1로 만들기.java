import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
//		while (true) {
//			if (N == 1) {
//				break;
//			}
//			if (N % 3 == 1) {
//				N -= 1;
//				count++;
//			} else if (N % 3 == 0) {
//				N /= 3;
//				count++;
//			} else if (N % 2 == 0) {
//				N /= 2;
//				count++;
//			}
//		}
		
		int[] arr = new int[N+1];
		arr[1] = 0;
		
		for (int i = 2; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			if (i%2 == 0) {
				int temp = i/2;
				min = Math.min(min, arr[temp]);
			} 
			if (i%3 == 0) {
				int temp = i/3;
				min = Math.min(min, arr[temp]);
			}
			int temp = i-1;
			min = Math.min(min, arr[temp]);
	
			arr[i] = min+1;
		}
		
		System.out.println(arr[N]);
		
		
		
//		System.out.println(count);
	}
}