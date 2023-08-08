import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}
		boolean check = false;
		
		if (arr[0] == 1) {
			int count = 0;
			for (int i = 1; i < 8; i++) {
				if (arr[i-1] + 1 == arr[i]) {
					count++;
				}
			}
			if (count == 7) {
				System.out.println("ascending");
			} else {
				System.out.println("mixed");
			}
		} else if (arr[0] == 8) {
			int count = 0;
			for (int i = 0; i < 7; i++) {
				if (arr[i] - 1 == arr[i+1]) {
					count++;
				}
			}
			if (count == 7) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}
		} else {
			System.out.println("mixed");
		}
		
	}
}
