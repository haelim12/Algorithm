import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int count = 1;
			int day = 0;
			
			while (m1<=m2) {
				int m = m1;
				int d = 0;
				switch (m1) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					d = 31;
					break;
				case 4: case 6: case 9: case 11:
					d = 30;
					break;
				case 2:
					d = 28;
					break;
				}
				
				if (count == 1 && m1 == m2) {
					day += d2 - d1 + 1;
//					System.out.println(day);
				} else if (count == 1) {
					day += d - d1 + 1;
				} else if (m2 == m1) {
					day += d2;
//					System.out.println(day);
				} else {
					day += d;
//					System.out.println(day);
				}
				m1++;
				count++;
			}
			
			System.out.printf("#%d %d\n", tc, day);
		}
	}
}