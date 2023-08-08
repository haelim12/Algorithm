import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[] house = new int[n+1];
			int[] newHouse = new int[n+1];
			int count = 0;
			
			for (int i = 0; i < k; i++) {
				if (count == 0) {
					for (int j = 0; j < n+1; j++) {
						house[j] = j;
					}
					count++;
				}
//				System.out.println(Arrays.toString(house));
				for (int j = 1; j < n+1; j++) {
					newHouse[j] = newHouse[j-1] + house[j];
					house[j] = newHouse[j];
				}
//				System.out.println(Arrays.toString(newHouse));
			}
			
			System.out.println(newHouse[n]);
			
		}
	}
}
