import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
//        System.out.println(sum);

        Arrays.sort(arr);
        int no1 = 0;
        int no2 = 0;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (sum-arr[i]-arr[j] == 100) {
                    no1 = arr[i];
                    no2 = arr[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != no1 && arr[i] != no2) {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
