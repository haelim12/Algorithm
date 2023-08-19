import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1;
        int s = 1;
        int m = 1;
        int y = 1;

        while (true) {
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
            if (e==E && s==S && m==M) {
                break;
            }
            e++;
            s++;
            m++;
            y++;
        }

        System.out.println(y);

    }
}
