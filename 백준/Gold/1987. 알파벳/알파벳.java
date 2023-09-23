import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String[][] alpha;
    static boolean[] vis;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        alpha = new String[R][C];
        vis = new boolean[26];

        for (int i = 0; i < alpha.length; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < alpha[0].length; j++) {
                alpha[i][j] = temp[j];
            }
        }
        
        dfs(0,0,1);

        System.out.println(max);
    }

    public static void dfs(int r, int c, int count) {
        vis[alpha[r][c].charAt(0)-'A'] = true;

        max = Math.max(max, count);

        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr>=0 && nr<alpha.length && nc>=0 && nc< alpha[0].length && !vis[alpha[nr][nc].charAt(0) - 'A']) {
                dfs(nr, nc, count+1);
            }
        }

        vis[alpha[r][c].charAt(0)-'A'] = false;

    }
}
