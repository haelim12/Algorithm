import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if (k == 0) {
				break;
			}
			
			arr = new int[k];
			nums = new int[6];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr));
			
			boolean[] vis = new boolean[k];
			dfs(0, vis);
			System.out.println();
		}
	
	}
	public static void dfs(int index, boolean[] vis) {
		if (index == nums.length) {
//			System.out.println(Arrays.toString(vis));
//			System.out.println(Arrays.toString(nums));
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (index == 0) {
				vis[i] = true;
				nums[index] = arr[i];
				dfs(index+1, vis);
				vis[i] = false;
			}
			else if (arr[i]>nums[index-1] && !vis[i]) {
				vis[i] = true;
				nums[index] = arr[i];
//				System.out.println("되고있나");
				dfs(index+1, vis);
				vis[i] = false;
			}
		}
	}
}