import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			List<Character>[] arr = new List[5];
			
			for (int i = 0; i < arr.length; i++) {
				String str = sc.nextLine();
				arr[i] = new ArrayList<>();
				for (int j = 0; j < str.length(); j++) {
					arr[i].add(str.charAt(j));
				}
			}
			System.out.printf("#%d ", tc);
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (j < arr[i].size()) {
						System.out.print(arr[i].get(j));
					}
				}
			}
			System.out.println();
		}
	}
}