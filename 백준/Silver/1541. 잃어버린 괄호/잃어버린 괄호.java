import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();


        String str = st.nextToken();
        String[] arr = str.split("-");

        int result = 0;
//        System.out.println(Arrays.toString(arr));
        if (arr.length == 1) {
            String[] allplus = str.split("\\+");
            for (int i = 0; i < allplus.length; i++) {
                result += Integer.parseInt(allplus[i]);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                String tempstr = arr[i];
                String[] temparr = tempstr.split("\\+");
                for (int j = 0; j < temparr.length; j++) {
                    temp.offer(Integer.parseInt(temparr[j]));
                }
//            System.out.println(Arrays.toString(temparr));
                int sum = 0;
                while (!temp.isEmpty()) {
                    sum += temp.poll();
                }
                q.offer(sum);
            }

            result = q.poll();
//            System.out.println(result);
            while (!q.isEmpty()) {
                result -= q.poll();
            }
        }
        System.out.println(result);
    }
}
