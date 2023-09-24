import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] res;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        res = new int[M];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        sb = new StringBuilder();
        recursion(0, 0);
        System.out.println(sb);
    }

    public static void recursion(int count, int start) {
        if (count == M) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == before) {
                continue;
            }
            res[count] = arr[i];
            recursion(count+1, i);

            before = arr[i];
        }
    }
}
