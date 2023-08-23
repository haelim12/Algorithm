import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Integer[] newArr = new Integer[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            newArr[i] = arr[i];
        }

        Arrays.sort(newArr, Collections.reverseOrder());

//        System.out.println(Arrays.toString(newArr));

        int count = 0;
        for (int i = 0; i < newArr.length; i++) {
            int temp = money / newArr[i];
            if (temp >= 1) {
                count += temp;
                money = money - newArr[i] * temp;
//                System.out.println();
            }
        }

        System.out.println(count);
    }
}
