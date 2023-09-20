import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			arr = new int[N+1];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			
			int[][] map = new int[M][2];
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int num = sc.nextInt();
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
				
				if (num == 0) { // 합칠 경우
					union(map[i][0], map[i][1]);
					
				} else { // 찾는 경우
					if (check(map[i][0], map[i][1])) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
		}
		
	}
	
	public static int find (int a) {
        if (a == arr[a]) { // 정점 a가 자신의 부모인 경우, a를 반환
            return a;
        }
        return arr[a] = find(arr[a]); // 아닐 경우, a의 부모를 찾고 반환된 부모 arr[a]에 저장
    }
	
	// 두 정점이 서로 다른 집합에 속해 있으면 한 집합으로 합치기
    public static void union (int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a != b) { // 서로 다른 집합에 속해 있을 경우
            arr[a] = b; // 합치기
        }
    }
    
    public static boolean check (int start, int end) {
    	int a = find(start);
        int b = find(end);

        if (a != b) { // 서로 다른 집합에 속해 있을 경우
            return false;
        }
        return true;
    }
}