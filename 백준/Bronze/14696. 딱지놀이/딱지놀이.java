import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int n = 0; n < N; n++) {
            int a = sc.nextInt();
            int[] arrA = new int[a];
            for (int i = 0; i < arrA.length; i++) {
                arrA[i] = sc.nextInt();
            }
            int b = sc.nextInt();
            int[] arrB = new int[b];
            for (int i = 0; i < arrB.length; i++) {
                arrB[i] = sc.nextInt();
            }

            int fight = 0;
            int find = 4;
            boolean winA = false;
            boolean winB = false;
            while (fight < 4) {
                int countA = 0;
                int countB = 0;
                for (int i = 0; i < arrA.length; i++) {
                    if (arrA[i] == find) {
                        countA++;
                    }
                }
                for (int i = 0; i < arrB.length; i++) {
                    if (arrB[i] == find) {
                        countB++;
                    }
                }

                if (countA>countB) {
                    winA = true;
                    break;
                } else if (countB>countA) {
                    winB = true;
                    break;
                }
                find--;
                fight++;
            }

            if (winA) {
                System.out.println("A");
            } else if (winB) {
                System.out.println("B");
            } else {
                System.out.println("D");
            }
        }
    }
}
