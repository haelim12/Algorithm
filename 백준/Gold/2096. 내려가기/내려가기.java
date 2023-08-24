import java.util.Scanner;

public class Main {
	static int[][] dp_min;
	static int[][] dp_max;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		map = new int[N][3];
		dp_min = new int[N][3];
		dp_max = new int[N][3];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
				dp_min[i][j] = -1;
				dp_max[i][j] = -1;
			}
		}
		
		dp_min[0][0] = map[0][0];
		dp_min[0][1] = map[0][1];
		dp_min[0][2] = map[0][2];
		
		dp_max[0][0] = map[0][0];
		dp_max[0][1] = map[0][1];
		dp_max[0][2] = map[0][2];
		
		
		
		int max = Math.max(findMax(N-1,0) , Math.max(findMax(N-1, 1), findMax(N-1, 2)));
		int min = Math.min(findMin(N-1,0) , Math.min(findMin(N-1, 1), findMin(N-1, 2)));
		
		System.out.println(max + " " + min);
		
	}
	
	public static int findMin (int i, int index) {
		if (dp_min[i][index] == -1) {
			if (index == 0) {
				dp_min[i][index] = Math.min(findMin(i-1, 0), findMin(i-1, 1)) + map[i][index];
			} else if (index == 1) {
				dp_min[i][index] = Math.min(findMin(i-1, 0), Math.min(findMin(i-1, 1), findMin(i-1, 2))) + map[i][index];
			} else {
				dp_min[i][index] = Math.min(findMin(i-1, 1), findMin(i-1, 2)) + map[i][index];
			}
		}
		
		return dp_min[i][index];
	}
	
	public static int findMax (int i, int index) {
		if (dp_max[i][index] == -1) {
			if (index == 0) {
				dp_max[i][index] = Math.max(findMax(i-1, 0), findMax(i-1, 1)) + map[i][index];
			} else if (index == 1) {
				dp_max[i][index] = Math.max(findMax(i-1, 0), Math.max(findMax(i-1, 1), findMax(i-1, 2))) + map[i][index];
			} else {
				dp_max[i][index] = Math.max(findMax(i-1, 1), findMax(i-1, 2)) + map[i][index];
			}
		}
		
		return dp_max[i][index];
	}
}