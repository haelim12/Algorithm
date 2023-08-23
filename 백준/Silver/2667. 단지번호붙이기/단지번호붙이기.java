import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] vis;
    static int[] house;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int start;
    static int count = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        vis = new boolean[N][N];
        house = new int[N*N];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1 && !vis[i][j]) {
                    count++;
                    vis[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(house);
        System.out.println(count);

        for (int i = 0; i < house.length; i++) {
            if (house[i] != 0) {
                System.out.println(house[i]);
            }
        }
    }
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        house[count]++;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];

            for (int d = 0; d < dr.length; d++) {
                int ni = r + dr[d];
                int nj = c + dc[d];

                if (ni >=0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] == 1 && !vis[ni][nj]) {
                    q.offer(new int[] {ni,nj});
                    vis[ni][nj] = true;
                    house[count]++;
                }
            }
        }

    }
}
