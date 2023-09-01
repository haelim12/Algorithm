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
	static List<int[]> list;
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
		List<Integer> temp = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (temp.isEmpty()) {
				temp.add(arr[i]);
			}
			else if (arr[i] != temp.get(temp.size()-1)) {
				temp.add(arr[i]);
			}
		}
		
		arr = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			arr[i] = temp.get(i);
		}
		
		list = new ArrayList<>();

		recursion(0, num);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				sb.append(list.get(i)[j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void recursion(int index, int[] num) {
		if (index == num.length) {
			list.add(num.clone());
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			num[index] = arr[i];
			recursion(index+1, num);
		}
		
	}
}