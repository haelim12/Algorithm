import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N+M+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i+j]++;
				}
			}
			
			int max = 0;
			int max_index = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
					max_index = i;
				}
			}
			List<Integer> maxArr = new ArrayList<>();
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max) {
					maxArr.add(i);
				}
			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < maxArr.size(); i++) {
				System.out.print(maxArr.get(i) + " ");
			}
			System.out.println();
			
		}
	}
}