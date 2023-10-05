import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < arr.length; i++) {
            dp[N][i] = arr[N][i];
        }
        System.out.println(find(1, 1));
    }

    public static int find(int depth, int idx) {
        if(depth == N) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
