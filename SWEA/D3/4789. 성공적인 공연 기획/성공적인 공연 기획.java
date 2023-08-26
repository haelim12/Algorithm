import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int tc = 1; tc <= T; tc++) {
            String[] str = sc.nextLine().split("");
            int[] arr = new int[str.length];

            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int clap = 0;
            int emp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (clap < i) {
                    int temp = i-clap;
                    clap += temp;
                    emp += temp;
                }
                clap += arr[i];
            }

            System.out.printf("#%d %d\n",tc , emp);
        }
    }
}
