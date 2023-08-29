import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;
	static int[] num;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		arr = new String[k];
		num = new int[k+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken();
		}
		
		boolean[] vis = new boolean[10];
		dfs(0, vis);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(list.get(list.size()-1)[i]);
		}
		sb.append("\n");
		for (int i = 0; i < num.length; i++) {
			sb.append(list.get(0)[i]);
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int index, boolean[] vis) {
		
		if (index == arr.length+1) {
			list.add(num.clone());
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (index == 0) {
				vis[i] = true;
				num[index] = i;
				dfs(index+1, vis);
				vis[i] = false;
			}
			else if (arr[index-1].equals("<") && num[index-1] < i && !vis[i]) {
				vis[i] = true;
				num[index] = i;
				dfs(index+1, vis);
				vis[i] = false;
			} else if (arr[index-1].equals(">") && num[index-1] > i && !vis[i]) {
				vis[i] = true;
				num[index] = i;
				dfs(index+1, vis);
				vis[i] = false;
			}
		}
	}
}