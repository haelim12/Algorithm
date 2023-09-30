import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N+1][2];
        int[] dp = new int[N+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            if (i + arr[i][0] - 1 > N) {
                continue;
            }
            if (dp[i + arr[i][0] - 1] < dp[i - 1] + arr[i][1]) {
                dp[i + arr[i][0] - 1] = dp[i - 1] + arr[i][1];
                max = Math.max(max, dp[i + arr[i][0] - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}
