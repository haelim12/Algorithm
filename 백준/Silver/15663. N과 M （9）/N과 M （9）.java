import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int[] arr;
	static List<String> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		int[] num = new int[M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		list = new ArrayList<>();
		
		boolean[] vis = new boolean[arr.length];
		recursion(0, num, vis);
		StringBuilder sb = new StringBuilder();
//		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void recursion(int index, int[] num, boolean[] vis) {
		if (index == num.length) {
			String temp = change(num);
			if (!list.contains(temp)) {
				list.add(temp);
			}
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!vis[i]) {
				num[index] = arr[i];
				vis[i] = true;
				recursion(index+1, num, vis);
				vis[i] = false;
			}
		}
	}
	
	public static String change(int[] num) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			temp.append(num[i]).append(" ");
		}
		return temp.toString();
	}
}