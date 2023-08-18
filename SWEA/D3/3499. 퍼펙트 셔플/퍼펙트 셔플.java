import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Queue<String> tmp1 = new LinkedList<>();
			Queue<String> tmp2 = new LinkedList<>();
			Queue<String> queue = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = st.nextToken();
			}
			if (arr.length % 2 == 1) { // 길이가 홀수일 때
				for (int i = 0; i < arr.length/2 +1; i++) {
					tmp1.add(arr[i]);
				}
				for (int i = arr.length/2 +1; i < arr.length; i++) {
					tmp2.add(arr[i]);
				}
			} else {
				for (int i = 0; i < arr.length/2; i++) {
					tmp1.add(arr[i]);
				}
				for (int i = arr.length/2; i < arr.length; i++) {
					tmp2.add(arr[i]);
				}
			}
			
			
			while (!tmp1.isEmpty() || !tmp2.isEmpty()) {
				queue.add(tmp1.poll());
				if (tmp2.isEmpty()) {
					continue;
				}queue.add(tmp2.poll());
			}
			
			System.out.printf("#%d ", tc);
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
			
			
			
		}
	}
}