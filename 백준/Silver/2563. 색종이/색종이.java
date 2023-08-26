import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[100][100];

        for (int n = 0; n < N; n++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
