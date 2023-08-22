import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max_count = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(N);
            temp.add(i);
            int start = N;
            int next = i;

            while (true) {
                int num = start - next;
                if (num >= 0) {
                    temp.add(num);
                } else {
                    break;
                }
                start = next;
                next = num;
            }

            if (max_count < temp.size()) {
                max_count = temp.size();
                list = temp;
            }
        }

        System.out.println(max_count);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
