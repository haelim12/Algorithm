import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			
			boolean check = true;
			label : while (check) {
				for (int i = 1; i <= 5; i++) {
					if (q.peek()-i <= 0) {
						q.poll();
						q.add(0);
						check = false;
						break label;
					} else {
						q.add(q.poll()-i);
					}
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}