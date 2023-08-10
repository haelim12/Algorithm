import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		// 상 하 좌 우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		String[][] arr = new String[N][M];
		
		for (int i = 0; i < arr.length; i++) {
			String str = sc.nextLine();
			arr[i] = str.split("");
		}
		
		int count = 0;
		int min_count = Integer.MAX_VALUE;
//		boolean check = true;
		
		for (int h = 0; h < arr.length-7; h++) {
			for (int l = 0; l < arr[0].length-7; l++) {
				// 행-짝수 열-짝수 : W일때
				count = 0;
				for (int i = h; i < h+8; i++) {
					for (int j = l; j < l+8; j++) {
						// 짝 짝 -> W
						if (i%2==0 && j%2==0) {
							if (!arr[i][j].equals("W")) {
								count++;
							}
						}
						// 짝 홀 -> B
						if (i%2==0 && j%2==1) {
							if (!arr[i][j].equals("B")) {
								count++;
							}
						}
						// 홀 짝 -> B
						if (i%2==1 && j%2==0) {
							if (!arr[i][j].equals("B")) {
								count++;
							}
						}
						// 홀 홀 -> W
						if (i%2==1 && j%2==1) {
							if (!arr[i][j].equals("W")) {
								count++;
							}
						}
					}
				}
				
				min_count = Math.min(min_count, count);
				
				// 행-짝수 열-짝수 : W일때
				count = 0;
				for (int i = h; i < h+8; i++) {
					for (int j = l; j < l+8; j++) {
						// 짝 짝 -> B
						if (i%2==0 && j%2==0) {
							if (!arr[i][j].equals("B")) {
								count++;
							}
						}
						// 짝 홀 -> W
						if (i%2==0 && j%2==1) {
							if (!arr[i][j].equals("W")) {
								count++;
							}
						}
						// 홀 짝 -> W
						if (i%2==1 && j%2==0) {
							if (!arr[i][j].equals("W")) {
								count++;
							}
						}
						// 홀 홀 -> B
						if (i%2==1 && j%2==1) {
							if (!arr[i][j].equals("B")) {
								count++;
							}
						}
					}
				}
				min_count = Math.min(min_count, count);
			}
		}


//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println(min_count);

		
	}
}