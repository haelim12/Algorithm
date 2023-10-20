import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(queue.size() != 1){
            for (int i = 1; i < K; i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}
