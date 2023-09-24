import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] res;
    static boolean[] vis;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        res = new int[M];
        vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 오름차순 정렬

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

        int num = 0;
        for (int i = start; i < nums.length; i++) {
            if (!vis[i]) {
                if (num == nums[i]) {
                    continue;
                }

                vis[i] = true;
                res[count] = nums[i];
                recursion(count+1, i+1);
                vis[i] = false;

                num = nums[i];
            }
        }
    }
}
