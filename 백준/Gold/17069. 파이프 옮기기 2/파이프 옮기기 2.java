import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] map;
    static long[][][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new long[N][N];
        dp = new long[N][N][3]; // 가로, 세로, 대각선

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1; // 가로
        dp[0][0][1] = 0; // 세로
        dp[0][0][2] = 0; // 대각선

        System.out.println(movepipe());

    }
    public static long movepipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (j-1>0 && map[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로
                }
                if (i>0 && map[i][j] == 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]; // 세로
                }
                if (i>0 && j-1>0 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; // 대각선
                }
            }
        }
        return dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
    }
}
