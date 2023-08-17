import java.util.Scanner;

public class Main {
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		z(r,c, (int)Math.pow(2, N));
		
		System.out.println(count);
	}
	
	public static void z(int r, int c, int size) {
		if (size == 1) {
			return;
		}
		if (r < size/2 && c < size/2) {
			z(r, c, size/2);
//			System.out.println("1사분면");
		} else if (r < size/2 && c >= size/2) {
			count += size*size / 4;
			z(r, c-size/2, size/2);
//			System.out.println("2사분면");
		} else if (r >= size/2 && c >= size/2) {
			count += size * size / 4 * 3;
			z(r-size/2, c-size/2, size/2);
//			System.out.println("3사분면");
		} else {
			count += size * size /4 * 2;
			z(r-size/2, c, size/2);
//			System.out.println("4사분면");
		}
		
	}
}