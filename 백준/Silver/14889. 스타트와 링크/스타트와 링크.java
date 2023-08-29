import java.util.*;

public class Main {
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		List<Integer> start = new ArrayList<>();
		List<Integer> link = new ArrayList<>();
		dfs(0, start, link);
		
		System.out.println(min);
		
	}
	
	public static void dfs(int index, List<Integer> start, List<Integer> link) {
		
		if (index == map.length) {
			int sumS = 0;
			int sumL = 0;
			for (int i = 0; i < start.size(); i++) {
				for (int j = 0; j < start.size(); j++) {
					sumS += map[start.get(i)][start.get(j)];
					sumL += map[link.get(i)][link.get(j)];
				}
			}
//			System.out.println("sum값 " + sumS + " "  + sumL);
			int diff = Math.abs(sumL - sumS);
			min = Math.min(min, diff);
			return;
		}
		if (start.size() < map.length/2) {
			start.add(index);
		dfs(index+1, start, link);
		start.remove(start.size()-1);
		}
		
		if (link.size()<map.length/2) {
			link.add(index);
		dfs(index+1, start, link);
		link.remove(link.size()-1);
		}
		
	}
}