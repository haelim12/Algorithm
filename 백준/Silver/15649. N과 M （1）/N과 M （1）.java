import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] nums = new int[num];
		int r = sc.nextInt();
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		
		boolean[] visited = new boolean[nums.length];
		int[] res = new int[r];
		
		perm(nums, visited, res, 0, r);
	}
	
	public static void perm(int[] nums, boolean[] visited, int[] res, int i, int r) {
		// i가 0부터 출발 -> r이 되면 멈춤
		if (i == r) {
			for (int j = 0; j < res.length; j++) {
				System.out.print(res[j] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int j = 0; j < nums.length; j++) {
			if (!visited[j]) {
				visited[j] = true;
				res[i] = nums[j];
				perm(nums, visited, res, i+1, r);
				
				visited[j] = false;
			}
		}
	}
}