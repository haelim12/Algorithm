import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        // 산술평균
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = (int) Math.round(sum/arr.length);
        sb.append(avg).append("\n");

        // 중앙값
        Arrays.sort(arr);
        sb.append(arr[arr.length/2]).append("\n");

        // 최빈값
        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check) {
                mod = arr[i];
                check = false;
            }
        }

        sb.append(mod).append("\n");

        // 범위
        sb.append(arr[arr.length-1] - arr[0]);

        System.out.println(sb);
    }
}
