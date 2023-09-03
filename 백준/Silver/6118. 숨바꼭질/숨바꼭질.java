import java.util.*;

public class Main {
    static int N,M;
    static List<Integer>[] arr;
    static boolean[] vis;
    static int[] distance;
    static int num, count;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new List[N+1];
        vis = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            arr[i].add(j);
            arr[j].add(i);
        }

        bfs(1);

        for (int i = 1; i < arr.length; i++) {
            if (distance[i] == max) {
                num = i;
                break;
            }
        }

        System.out.println(num + " " + max + " " + count);

    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < arr[temp].size(); i++) {
                int next = arr[temp].get(i);
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                    distance[next] = distance[temp] + 1;

                    if (distance[next] > max) {
                        max = distance[next];
                        count = 1;
                    } else if (distance[next] == max) {
                        count++;
                    }
                }
            }
        }
    }
}
