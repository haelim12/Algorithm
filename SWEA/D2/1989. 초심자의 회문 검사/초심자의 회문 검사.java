import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc < T+1; tc++) {
			
			String str = sc.next();
			char[] word = str.toCharArray();
			
			int count = 0;
			
			for (int j = 0; j < (word.length/2); j++) {
				if (word[j] == word[word.length-j-1]) {
					count += 1;
				}
			}
			
			if (count == word.length/2) {
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
			count = 0;
		}
	}
}