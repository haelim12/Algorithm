import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] ledNumbers;
    static int[][] changes;
    static int[] digits; // 바꿀 숫자 배열로 바꿔서 저장
    static int N, P, X;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        String[] X1 = Integer.toString(X).split("");

        init();
        changes = new int[10][10];
        changecount();
//        for (int i = 0; i < changes.length; i++) {
//            System.out.println(Arrays.toString(changes[i]));
//        }

        digits = new int[K]; // K자리 수 바꿀 수 있는 거
        int index = digits.length-1;
        for (int i = X1.length-1; i >=0; i--) { // 하..
            digits[index] = Integer.parseInt(X1[i]);
            index--;
        }

        int[] arr = new int[K];
        recursion(0, 0, arr);

        System.out.println(count);
    }

    static void init() {
        ledNumbers = new int[10][7];
        ledNumbers[0] = new int[] {1,1,1,1,1,0,1};
        ledNumbers[1] = new int[] {0,1,1,0,0,0,0};
        ledNumbers[2] = new int[] {1,1,0,1,1,1,0};
        ledNumbers[3] = new int[] {1,1,1,1,0,1,0};
        ledNumbers[4] = new int[] {0,1,1,0,0,1,1};
        ledNumbers[5] = new int[] {1,0,1,1,0,1,1};
        ledNumbers[6] = new int[] {1,0,1,1,1,1,1};
        ledNumbers[7] = new int[] {1,1,1,0,0,0,0};
        ledNumbers[8] = new int[] {1,1,1,1,1,1,1};
        ledNumbers[9] = new int[] {1,1,1,1,0,1,1};
    }

    static void changecount() {
        for (int i = 0; i < changes.length; i++) {
            for (int j = 0; j < changes[0].length; j++) {
                int count = 0;
                for (int k = 0; k < ledNumbers[i].length; k++) {
                    if (ledNumbers[i][k] != ledNumbers[j][k]) {
                        count++;
                    }
                }
                changes[i][j] = count;
            }
        }
    }

    static boolean checkNum(int num) {
        if (num <= N && 1 <= num && num != X) {
            return true;
        }
        return false;
    }

    static void recursion(int index, int depth, int[] arr) {
        if (index == arr.length) {
            int num = 0;
            for (int i = arr.length-1; i >= 0 ; i--) {
                num += Math.pow(10, arr.length-1-i) * arr[i];
            }
            if (checkNum(num)) {
                count++;
            }
            return;
        }
        for (int i = 0; i < changes.length; i++) {
            if (depth + changes[digits[index]][i] <= P) {
                arr[index] = i;
                recursion(index+1, depth + changes[digits[index]][i], arr);
            }
        }
    }
}
