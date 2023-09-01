import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] firstPrime = {2,3,5,7};
	static int[] nextPrime = {1,3,5,7,9};
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sb = new StringBuilder();
		int[] arr = new int[N];
		choose(0, arr);
		System.out.println(sb);
	}
	
	public static void choose(int n, int[] arr) {
		if (n == N) {
			int num1 = makeprime(n, arr);
			if (checkprime(num1)) {
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
				sb.append("\n");
			}
//			System.out.println(Arrays.toString(arr));
			return;
		}
		
		if (n == 0) {
			for (int j = 0; j < firstPrime.length; j++) {
				arr[n] = firstPrime[j];
				choose(n+1, arr);
			}
		}
		
		if (n > 0) {
			for (int i = 0; i < nextPrime.length; i++) {
				arr[n] = nextPrime[i];
				if (checkprime(makeprime(n, arr))) {
					choose(n+1, arr);
				}
			}
		}	
	}
	
	public static boolean checkprime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int makeprime(int n, int[] arr) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			num += arr[i]*Math.pow(10, n-i-1);
		}
		return num;
	}
}