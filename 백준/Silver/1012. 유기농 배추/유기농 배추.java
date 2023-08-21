import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] vis;

    static int count = 0;
    static Queue<int[]> queue;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            vis = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                arr[r][c] = 1;
            }

            count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1 && !vis[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            i = temp[0];
            j = temp[1];
            vis[i][j] = true;

            for (int d = 0; d < dr.length; d++) {
                int ni = i + dr[d];
                int nj = j + dc[d];

                if (ni>=0 && ni<N && nj>=0 && nj<M) {
                    if (!vis[ni][nj] && arr[ni][nj] == 1) {
                        q.add(new int[] {ni,nj});
                        vis[ni][nj] = true;
                    }
                }
            }

        }
    }
}
