import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 0; tc < T; tc++) {
			String[] str = sc.nextLine().split("");
			int score = 0;
			int count = 0;
			for (int i = 0; i < str.length; i++) {
				if (str[i].equals("O")) {
					count++;
				}
				else {
					count = 0;
				}
				score += count;
			}
			System.out.println(score);
		}
	}
}