import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <=N ; i++) {
            q.offer(i);
        }

        int last = 0;
        while (N!= 1 && !q.isEmpty()) {
            q.poll();
            if (!q.isEmpty()) {
                int temp = q.poll();
                if (q.isEmpty()) {
                    last = temp;
                    break;
                } else {
                    q.offer(temp);
                }
            }
        }
        if (N == 1) {
            System.out.println(1);
        } else {
            System.out.println(last);
        }
    }
}
