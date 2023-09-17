import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 1;
        boolean imp = false;
        while (end != start) {
            if (end < start) {
                System.out.println(-1);
                imp = true;
                break;
            }

            if (end % 10 == 1) { // 뒤에가 1일 경우
                end = end / 10;
            } else if (end % 2 == 0) { // 짝수로 끝날 경우
                end = end / 2;
            } else {
                System.out.println(-1);
                imp = true;
                break;
            }

            count++;
        }
        if (!imp) {
            System.out.println(count);
        }
    }
}
