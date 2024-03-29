import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();

            int[] box = new int[N+1];

            for (int i = 1; i <= Q; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();

                for (int j = L; j <= R; j++) {
                    box[j] = i;
//                    System.out.println(Arrays.toString(box));
                }
            }

            System.out.printf("#%d ", tc);
            for (int i = 1; i < box.length; i++) {
                System.out.print(box[i] + " ");
            }
            System.out.println();
        }
    }
}
