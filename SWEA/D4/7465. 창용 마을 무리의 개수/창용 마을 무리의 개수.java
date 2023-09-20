import java.util.ArrayList;
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
			
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            }
            
            int count = 0; 
            
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == i) {
                    count++;
                }
            }
             
            System.out.printf("#%d %d\n", tc, count);
		}
	}
	public static int find (int a) {
        if (a == arr[a]) { // 정점 a가 자신의 부모인 경우, a를 반환
            return a;
        }
        return arr[a] = find(arr[a]); // 아닐 경우, a의 부모를 찾고 반환된 부모 arr[a]에 저장
    }

    public static void union (int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a > b)
            arr[a] = b;
        else
            arr[b] = a;
    }
}