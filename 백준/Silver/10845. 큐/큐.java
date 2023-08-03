import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
//        q.add(0);
        int num = 0;

        for(int i = 0; i < N; i++) {

            String str = sc.next();

            switch (str) {

                case "push":
                    num = sc.nextInt();
                    q.offer(num);
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(q.poll()).append("\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(num).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
