import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 우 하 좌 상
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int dir = 0; // 우

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        int r = 0;
        int c = 0;
        int num = 1;
        int count = 0; // 꺾을 때마다 횟수++
        arr[r][c] = 1;

        while (num <= N*M) {
            if (dir == 0) { // 우
                c++;
                if (c >= M || arr[r][c] != 0) {
                    c--;
                    r++;
                    count++;
                    dir = 1;
                }
            } else if (dir == 1) { // 하
                r++;
                if (r >= N || arr[r][c] != 0) {
                    r--;
                    c--;
                    count++;
                    dir = 2;
                }
            } else if (dir == 2) { // 좌
                c--;
                if (c < 0 || arr[r][c] != 0) {
                    c++;
                    r--;
                    count++;
                    dir = 3;
                }
            } else if (dir == 3) { // 상
                r--;
                if (r < 0 || arr[r][c] != 0) {
                    r++;
                    c++;
                    count++;
                    dir = 0;
                }
            }
            arr[r][c] = ++num;
        }

        System.out.println(count-1);
    }
}
