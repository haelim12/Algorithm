import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static String[][] map;
    static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < map.length; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = temp[j];
            }
        }

        // 정상
        int normal = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!vis[i][j]) {
                    dfs(i,j);
                    normal++;
                }
            }
        }

        // 적록색약
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        vis = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!vis[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(normal + " " + count);

    }
    public static void dfs(int r, int c) {
        vis[r][c] = true;
        String temp = map[r][c];
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr>=0 && nr<N && nc>=0 && nc<N
                    && !vis[nr][nc] && map[nr][nc].equals(temp)) {
                dfs(nr,nc);
            }
        }

    }
}
