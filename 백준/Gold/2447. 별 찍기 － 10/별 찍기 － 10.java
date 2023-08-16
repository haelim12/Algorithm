import java.util.Scanner;

public class Main {
	public static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N][N];
		
		star(0, 0, N-1, N-1);
		
		Character[][] newArr = new Character[N][N];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr.length; j++) {
				if (arr[i][j] == 1) {
					sb.append('*');
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void star(int x1, int y1, int x2, int y2) {
		int size = y2-y1 + 1;
		if (size <= 3) {
			arr[x1][y1] = 1;
			arr[x1][y1+1] = 1;
			arr[x1][y1+2] = 1;
			arr[x1+1][y1] = 1;
			arr[x1+1][y1+1] = 0;
			arr[x1+1][y1+2] = 1;
			arr[x1+2][y1] = 1;
			arr[x1+2][y1+1] = 1;
			arr[x1+2][y1+2] = 1;
			return;
		}

		size = size/3;
		
		// (x1,y1) -> (x2, y2)
		star(x1, y1, x1+size-1, y1+size-1);
		star(x1, y1+size, x1+size-1, y1+size*2-1);
		star(x1, y1+size*2, x1+size-1, y1+size*3-1);
		
		star(x1+size, y1, x1+size*2-1, y1+size-1);
		star(x1+size, y1+size*2, x1+size*2-1, y1+size*3-1);
		
		star(x1+size*2, y1, x1+size*3-1, y1+size-1);
		star(x1+size*2, y1+size, x1+size*3-1, y1+size*2-1);
		star(x1+size*2, y1+size*2, x1+size*3-1, y1+size*3-1);
	}
	
	
}