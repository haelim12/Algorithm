import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int r;
    static int c;
    static int count;
    static Character[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new Character[N][M];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String str = st2.nextToken();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'I') {
                    r = i;
                    c = j;
                }
            }
        }

        vis = new boolean[N][M];
        count = 0;
        // 도연이 위치 찾기

        find(r,c);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

    }

    public static void find(int r, int c) {
        vis[r][c] = true;

        if (arr[r][c] == 'P') {
            count++;
        }

        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && !vis[nr][nc]) {
                if (arr[nr][nc] != 'X') {
                    find(nr,nc);
                }
            }
        }
    }
}
