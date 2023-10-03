import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        int[] W = new int[N+1]; // 무게
        int[] V = new int[N+1]; // 가치
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i < W.length; i++) {
            W[i] = sc.nextInt(); // 무게
            V[i] = sc.nextInt(); // 가치
        }

        for (int i = 1; i < W.length; i++) {
            for (int j = 1; j < dp[0].length ; j++) {
                if (W[i] > j) { // i번째 무게 더 담지 못하는 경우
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
