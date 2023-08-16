import java.util.Scanner;

public class Main {
	public static int white = 0;
	public static int blue = 0;
	public static int[][] arr;
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][N];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void cut(int r, int c, int size) {
		
		if (color(r, c, size)) {
			if (arr[r][c] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		int newSize = size/2;
		
		cut(r, c, newSize); // 1사분면
		cut(r, c+newSize, newSize); // 2사분면
		cut(r+newSize, c+newSize, newSize); // 3사분면
		cut(r+newSize, c, newSize); // 4사분면
	}
	
	public static boolean color(int r, int c, int size) {
		int color = arr[r][c];
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if (arr[i][j] != color) {
					// 색 다를 때 false
					return false;
				}
			}
		}
		return true;
	}
}