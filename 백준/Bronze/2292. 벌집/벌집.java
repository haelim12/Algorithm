import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int room = sc.nextInt();
		int count = 1;
		int bee = 1;
		
		while (true) {
			if (room <= bee) {
				break;
			}
			bee += 6*count;
			count++;
		}
		System.out.println(count);
	}
}
