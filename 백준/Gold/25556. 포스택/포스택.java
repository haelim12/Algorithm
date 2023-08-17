import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        Stack<Integer> s4 = new Stack<>();

        boolean check = true;

        for (int i = 0; i < N; i++) {
            if (s1.empty() || s1.peek() < arr[i]) {
                s1.push(arr[i]);
            } else if (s2.empty() || s2.peek() < arr[i]) {
                s2.push(arr[i]);
            } else if (s3.empty() || s3.peek() < arr[i]) {
                s3.push(arr[i]);
            } else if (s4.empty() || s4.peek() < arr[i]) {
                s4.push(arr[i]);
            } else {
                check = false;
                break;
            }
        }

//        Arrays.sort(arr);
//        int[] newarr = new int[N];
//
//        for (int i = N-1; i >= 0; i--) {
//            if (s1.peek() == arr[i]) {
//                s1.pop();
//            } else if (s2.peek() == arr[i]) {
//                s2.pop();
//            } else if (s3.peek() == arr[i]) {
//                s3.pop();
//            } else if (s4.peek() == arr[i]) {
//                s4.pop();
//            }
//        }

        if (!check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
