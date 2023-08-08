import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int count = 0;
			int[] nums = new int[100];
			
			for (int i = 0; i < 100; i++) {
				nums[i] = sc.nextInt();
			}
			
			while (count < N) {
				
				// 정렬
				for (int i = 0; i < 100; i++) {
					int minIdx = i;
					for (int j = i+1; j < 100; j++) { // minIdx 찾기
						if (nums[j] < nums[minIdx]) {
							minIdx = j;
						}
					}
					
					if (minIdx != i) {
						int tmp = nums[i];
						nums[i] = nums[minIdx];
						nums[minIdx] = tmp;
					}
				}
				count++;
				
				nums[99] -= 1;
				nums[0] += 1;
				
				if (nums[0] == nums[99] || nums[99] - nums[0] == 1) {
//					System.out.println(nums[99] - nums[0]);
					break;
				}
				
//				System.out.println(Arrays.toString(nums));
			}
			
			for (int i = 0; i < 100; i++) {
				int minIdx = i;
				for (int j = i+1; j < 100; j++) { // minIdx 찾기
					if (nums[j] < nums[minIdx]) {
						minIdx = j;
					}
				}
				
				if (minIdx != i) {
					int tmp = nums[i];
					nums[i] = nums[minIdx];
					nums[minIdx] = tmp;
				}
			}
			if (nums[99] == nums[0] || nums[99] - nums[0] == 1) {
				System.out.printf("#%d %d\n", tc, nums[99] - nums[0]);
			} else {
				System.out.printf("#%d %d\n", tc, nums[99] - nums[0]);
			}
		}
	}
}
