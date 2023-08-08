import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			// 1. 데이터 중 가장 큰 값
			int K = -1;
			// 최대값을 찾는 for문
			for (int i = 0; i < N; i++) {
				if (K < nums[i]) {
					K = nums[i];
				}
			}
			
			int[] count = new int[K+1];
			
			// 2. 개수 카운팅
			for (int i = 0; i < N; i++) {
				count[nums[i]]++;
			}
			
			// 3. 누적 합
			for (int i = 1; i < count.length; i++) {
				count[i] += count[i-1];
			}
			
			// 4. 뒤에서부터 순회를 하며 정렬된 배열에 저장
			int[] sortArr = new int[N];
			for (int i = N-1; i >= 0; i--) {
				sortArr[--count[nums[i]]] = nums[i];
			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < sortArr.length; i++) {
				System.out.print(sortArr[i] + " ");
			}
            System.out.println();
		}
	}
}
