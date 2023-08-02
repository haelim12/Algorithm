import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        List<Integer> nlist = new ArrayList<Integer>();
        int size = 0;

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                nlist.remove(size-1);
                size--;
            } else {
                nlist.add(num);
                size++;
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nlist.get(i);
        }

        System.out.println(sum);
    }
}
