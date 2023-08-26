import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[][] board = new int[N][N];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for (int j = 0; j < board[0].length; j++) {
                boolean checkN = false;
                int temp = 0;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == 1) {
                        checkN = true;
                    } else if (board[i][j] == 2) {
                        if (checkN) {
                            temp++;
                            checkN = false;
                        }
                    }
                }
                count += temp;
            }

            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
