import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc < 11; tc++) {
			int N = sc.nextInt();
			int[] building = new int[N];
			int house = 0;
			
			for (int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}
			
			for (int i = 2; i < N-2; i++) {
				if (building[i] > building[i-1] && building[i] > building[i-2] &&
					building[i] > building[i+1] && building[i] > building[i+2]) {
					int min1 = Math.min(building[i]-building[i-1], building[i]-building[i-2]);
					int min2 = Math.min(building[i]-building[i+1], building[i]-building[i+2]);
					house += Math.min(min1, min2);
				}
			}
			
			System.out.printf("#%d %d\n", tc, house);
			
			
		}
	}
}
