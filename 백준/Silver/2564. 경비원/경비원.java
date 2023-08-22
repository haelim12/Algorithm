import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[N+1][M+1];
		Stack<int[]> stack = new Stack<>();

		int d;
		for (int k = 0; k < K; k++) {
			d = sc.nextInt();
			if (d == 1) { // 북
				stack.add(new int[] {0,sc.nextInt()});
			} else if (d == 2) { // 남
				stack.add(new int[] {N, sc.nextInt()});
			} else if (d == 3) { // 서
				stack.add(new int[] {sc.nextInt(), 0});
			} else { // 동
				stack.add(new int[] {sc.nextInt(), M});
			}
		}
		
		int dir;
		dir = sc.nextInt();
		int[] dong = new int[2];
		if (dir == 1) { // 북
			dong[0] = 0;
			dong[1] = sc.nextInt();
		} else if (dir == 2) { // 남
			dong[0] = N;
			dong[1] = sc.nextInt();
		} else if (dir == 3) { // 서
			dong[0] = sc.nextInt();
			dong[1] = 0;
		} else { // 동
			dong[0] = sc.nextInt();
			dong[1] = M;
		}
		
		int sum = 0;
		int min;
		if (dir == 1 || dir == 2) { // 북1, 남2
			
			while (!stack.isEmpty()) {
				int[] temp = stack.pop();
				
				int dif = (int) Math.abs(dong[0] - temp[0]);
				if (dif == 0) { // 같은 행에 있을 때
					sum += Math.abs(temp[1] - dong[1]);
//					System.out.println(sum);
				} else if (dif == N) {// 반대편에 있을 때
					min = Math.min(dong[1] + temp[1], 2*M-(dong[1] + temp[1]));
					sum += min + N;
//					System.out.println(sum);
				} else if (temp[1] == 0){ // 좌측에 있을 때
					if (dir == 1) {
						sum += dong[1] + temp[0];
					} else {
						sum += dong[1] + N-temp[0];
					}
//					System.out.println(sum);
				} else if (temp[1] == M) { // 우측에 있을 때
					if (dir == 1) {
						sum += M - dong[1] + temp[0];
					} else {
						sum += M - dong[1] + N - temp[0];
					}
				}
			}
		} else { // 서3, 동4
			while (!stack.isEmpty()) {
				int[] temp = stack.pop();

				if(temp[1] == dong[1]) { // 같은 열에 있을 때
					sum += Math.abs(temp[0] - dong[0]);
//					System.out.println(1);
				} else if (temp[0] == 0) { // 북쪽
					if (dir == 3) {
						sum += dong[0] + temp[1];
					} else {
						sum += dong[0] + M - temp[1];
					}
//					System.out.println(2);
				} else if (temp[0] == N) { // 남쪽
					if (dir == 3) {
						sum += N - dong[0] + temp[1];
					} else {
						sum += M - temp[1] + N - dong[0];
					}
//					System.out.println(3);
				} else { // 반대편에 있을 때
					min = Math.min(dong[0] + temp[0], 2*N-(dong[0] + temp[0]));
//					System.out.println(4);
					sum += min + M;
				}
			}	
		}
		System.out.println(sum);
		
	}
}