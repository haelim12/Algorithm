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
        dp[1] = 1;

        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                } else if (arr[i] == arr[j]) {
                    dp[i] = dp[j];
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}