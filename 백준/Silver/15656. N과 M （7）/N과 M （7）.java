import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] res;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N]; // 숫자 받을 배열
        res = new int[M]; // 재귀 후 저장할 배열

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 오름차순 정렬
//        System.out.println(Arrays.toString(arr));
        sb = new StringBuilder();
        recursion(0,0);
        System.out.println(sb);
    }

    public static void recursion(int n, int index) {
        if (n == M) { // M개 다 뽑았을 때
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            res[n] = arr[i];
            recursion(n+1, index++);
        }
    }
}
