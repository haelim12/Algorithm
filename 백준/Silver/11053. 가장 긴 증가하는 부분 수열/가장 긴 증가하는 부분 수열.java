import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
