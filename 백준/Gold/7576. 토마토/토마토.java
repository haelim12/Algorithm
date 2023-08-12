import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[N][M]; // 익힌 경우 1
        int count =0;
        int day = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st2.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                    count++;
                }
            }
        }

        while(!q.isEmpty()) {
            int tempCount = 0;
            while (count>0) { // count만큼 반복
                int[] idx = q.poll();
                count--;
//                System.out.println("돌아가나?");
                int x = idx[0];
                int y = idx[1];

                for (int d = 0; d < dr.length; d++) {
                    int ni = x + dr[d];
                    int nj = y + dc[d];
                    if (ni >=0 && ni<N && nj>=0 && nj<M&& box[ni][nj] == 0) {
                        box[ni][nj] = 1;
                        tempCount++;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
            count = tempCount;
            day++;
        }

        boolean check = true; // 안 익은 토마토가 있을 경우 false
        label : for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    check = false;
                    break label;
                }
            }
        }
        if (day == 0 && check) {
            check = false;
            System.out.println(0);
        }

        if (check) {
            System.out.println(day-1);
        }
    }
}

