import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<long[]> arr = new Stack<>(); // 띠용?!
//		long[] razor = new long[N];
		
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			
			int num = Integer.parseInt(st.nextToken());
			while(!arr.isEmpty() && arr.peek()[1] < num)
				arr.pop();
			if (!arr.isEmpty()) {
				sb.append(arr.peek()[0]).append(' ');
				arr.push(new long[] {i+1, num});
			} else {
				sb.append(0).append(' ');
				arr.push(new long[] {i+1, num});
			}
			System.out.print(sb);
		}
		
	}
}
