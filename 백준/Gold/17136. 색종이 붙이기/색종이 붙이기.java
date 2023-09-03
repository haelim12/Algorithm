import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] paper = {0,5,5,5,5,5};
    static boolean[][] vis;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        vis = new boolean[10][10];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0,0,0);

        if (min > 25) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }

    }

    public static void recursion(int r, int c, int count) {
        if (r==10) {
            min = Math.min(min, count);
            return;
        }

        if (c>=10) {
            recursion(r+1, 0, count);
            return;
        }

        if (map[r][c] == 1) {
            for (int i = 5; i >=1; i--) { // 색종이 사이즈
                int nr = r + i;
                int nc = c + i;
                if (paper[i]>0 && nr<=10 && nc<=10 && checkPaper(r,c,i)) {
                    paper[i] -= 1;
                    stick(r,c,i, 0); // 붙이면 0으로 바꾸기
                    recursion(r, c+1, count+1);
                    stick(r,c,i, 1);
                    paper[i] += 1;
                }
            }
        }
        else {
            recursion(r,c+1, count);
        }
    }
    public static void stick(int r, int c, int size, int change) {
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                map[i][j] = change;
            }
        }
    }

    public static boolean checkPaper(int r, int c, int size) {
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (i>=10 || j>=10 || map[i][j] ==0) {
                    return false;
                }
            }
        }
        return true;
    }
}