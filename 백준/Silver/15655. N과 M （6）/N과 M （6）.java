import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        int[] newArr = new int[M];
        recursion(0, newArr, 0);

        System.out.println(sb);

    }
    public static void recursion(int index, int[] newArr, int start) {
        if (index == M) {
            for (int i = 0; i < newArr.length; i++) {
                sb.append(newArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            newArr[index] = arr[i];
            recursion(index+1, newArr, i+1);
        }
    }
}
