import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int M;
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N]; // 입력 받을 배열

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        sb = new StringBuilder();
        boolean[] vis = new boolean[N]; // 방문배열
        int[] newArr = new int[M]; // 출력할 배열
        recursion(0, vis, newArr);

        System.out.println(sb);
    }
    public static void recursion(int index, boolean[] vis, int[] newArr) {

        if (index == M) {
            for (int i = 0; i < newArr.length; i++) {
                sb.append(newArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                newArr[index] = arr[i];
                recursion(index+1, vis, newArr);
                vis[i] = false;
            }
        }
    }
}
