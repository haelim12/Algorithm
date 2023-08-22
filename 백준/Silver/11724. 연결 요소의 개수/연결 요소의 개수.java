import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] vis;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        vis = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r][c] = arr[c][r] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                vis[i] = true;
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int j = 1; j < arr.length; j++) {
                if (!vis[j] && arr[temp][j] == 1) {
                    vis[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}
