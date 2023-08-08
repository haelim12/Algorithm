import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		// 정렬
		Arrays.sort(nums);
		
		int M = sc.nextInt();
		int[] find = new int[M];
		
		for (int i = 0; i < M; i++) {
			find[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		
		for (int i = 0; i < M; i++) {
			found = false;
			
			int st = 0; // 시작점
			int ed = N-1; // 끝점
			
			while (st <= ed) {
				int mid = (st+ed) / 2;
				if (nums[mid] == find[i]) {
					found = true;
					sb.append(1).append("\n");
					break;
				} else if (nums[mid] > find[i]) { // mid가 더 클 경우
					// 왼쪽 구간으로 이동
					ed = mid-1;
				} else { // mid가 더 작을 경우 
					// 오른쪽 구간으로 이동
					st = mid+1;
				}
			}
			if (!found) {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
	

}
