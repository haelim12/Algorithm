import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < block.length; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack  = new Stack<>();

        int max = Integer.MIN_VALUE;
        boolean check = false;
        int rain = 0;

        for (int i = 0; i < block.length; i++) {

            if (!check) {
                max = block[i];
                check = true;
            } else if (block[i] >= max) {
                while (!stack.isEmpty()) {
                    rain += max - stack.pop();
                }
                max = block[i];
            }
            stack.add(block[i]);

            if (i == block.length-1) {
                int temp = stack.pop();
                while (!stack.isEmpty()) {
                    int num = stack.pop();
                    if (temp >= num) {
                        rain += temp - num;
                    } else {
                        temp = num;
                    }
                }
            }
        }
        System.out.println(rain);
    }
}
