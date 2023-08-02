import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N-i; j++) {
				temp += arr[i+j];
				if (temp == M) {
					count ++;
				} else if (temp > M) {
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
