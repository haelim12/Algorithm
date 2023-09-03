import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] str1;
    static String[] str2;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().split("");
        str2 = br.readLine().split("");

        dp = new Integer[str1.length][str2.length];

        System.out.println(recursion(str1.length-1, str2.length-1));
    }
    public static int recursion(int i, int j) {
        if (i<0 || j<0) {
            return 0;
        }
        if (dp[i][j] == null) {
            if (str1[i].equals(str2[j])) {
                dp[i][j] = recursion(i-1, j-1) + 1;
            } else {
                dp[i][j] = Math.max(recursion(i-1,j), recursion(i,j-1));
            }
        }
        return dp[i][j];
    }
}
