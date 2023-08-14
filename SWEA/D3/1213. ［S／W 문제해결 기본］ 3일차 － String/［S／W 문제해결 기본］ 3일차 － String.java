import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스 10개
		
		for (int tc = 1; tc <= T; tc++) {
			tc = sc.nextInt();
			sc.nextLine();
			String find = sc.nextLine();
			Character[] word = new Character[find.length()];
			for (int i = 0; i < word.length; i++) {
				word[i] = find.charAt(i); // 찾는 단어 배열에 넣기
			}
//			System.out.println(Arrays.toString(word));
			
			
			String str = sc.nextLine();
			Character[] arr = new Character[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
//			System.out.println(Arrays.toString(arr));
			
			 // 같은 수만큼 세기 
			int count = 0; // 개수 세기
			
			for (int i = 0; i < arr.length-word.length+1; i++) {
				int len = 0;
				for (int j = 0; j < word.length; j++) {
					if(arr[i+j] == word[j]) {
						len++;
					}
				}
				if (len == word.length) {
					count++;
				}
			}
			System.out.printf("#%d %d\n",tc,count);
		}
	}
}