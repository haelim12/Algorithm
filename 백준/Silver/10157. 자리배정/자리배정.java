import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long M = sc.nextInt();
        long[][] map = new long[(int) N+1][(int) M+1];

        long K = sc.nextInt();

        int r = 1;
        int c = 1;
        int dir = 0; // 상 우 하 좌

        long num = 1;
        boolean seatcheck = false;

        if (K == num) {
            seatcheck = true;
        } else {

            while (num <= N * M) {

                if (num == K) {
                    seatcheck = true;
                    break;
                }
                // 상
                map[r][c] = num;
//            System.out.println(r + " " + c);

                if (dir == 0) { // 우
                    c++;
                    if (c > M || map[r][c] != 0) {
                        c--;
                        r++;
                        dir = 1;
                    }
                } else if (dir == 1) { // 하
                    r++;
                    if (r > N || map[r][c] != 0) {
                        r--;
                        c--;
                        dir = 2;
                    }
                } else if (dir == 2) { // 좌
                    c--;
                    if (c < 1 || map[r][c] != 0) {
                        c++;
                        r--;
                        dir = 3;
                    }
                } else { // 상
                    r--;
                    if (c < 1 || map[r][c] != 0) {
                        r++;
                        c++;
                        dir = 0;
                    }
                }
                num++;
            }
        }
        if (seatcheck) {
            System.out.println(r + " " + c);
        } else {
            System.out.println("0");
        }
    }
}
