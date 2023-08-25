import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			String[] str = sc.nextLine().split("");
			int count = 0;
			for (int i = 0; i < str.length; i++) {
				if (str[i].equals("0")) {
					continue;
				} else {
					for (int j = 0; j < str.length-i; j++) {
						if (str[i+j].equals("0")) {
							str[i+j] = "1";
						} else {
							str[i+j] = "0";
						}
					}
					count++;
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
	}
	
}