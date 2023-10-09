import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, K;
    static int[][] map;
    static boolean[][] vis;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max = Integer.MIN_VALUE;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            vis = new boolean[N][N];
            int peak = Integer.MIN_VALUE;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > peak) {
                        peak = map[i][j];
                    }
                }
            }

            result = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == peak) {
                        vis[i][j] = true;
                        boolean check = false;
                        dfs(i,j,1,map[i][j], check);
                        vis[i][j] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }

    public static void dfs(int i, int j, int count, int height, boolean check) {
        result = Math.max(count, result);

        for (int d = 0; d < dr.length; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];

            if (ni>=0 && ni<N && nj>=0 && nj<N && !vis[ni][nj]) {
                if (map[ni][nj] < height) {
                    vis[ni][nj] = true;
                    dfs(ni,nj,count+1, map[ni][nj], check);
                    vis[ni][nj] = false;
                } else if (!check && map[ni][nj] - K <= height-1) {
                    vis[ni][nj] = true;
                    check = true;
                    dfs(ni, nj, count+1, height-1, check);
                    vis[ni][nj] = false;
                    check = false;
                }
            }
        }
    }
}