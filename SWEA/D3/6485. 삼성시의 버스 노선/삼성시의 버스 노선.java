import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][2];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int P = sc.nextInt();
            int[] arr = new int[P];

            for (int i = 0; i < P; i++) {
                int c = sc.nextInt();
                int count = 0;
                for (int j = 0; j < map.length; j++) {
                    if (c >= map[j][0] && c <= map[j][1]) {
                        count++;
                    }
                }
                arr[i] = count;
            }
            System.out.printf("#%d ", tc);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
