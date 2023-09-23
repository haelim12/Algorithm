import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] city;
    static boolean[] vis;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        city = new List[N+1];
        vis = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 0; i < city.length; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());

            city[start].add(new int[] {end, fee});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);

    }

    public static void dijkstra(int start){

        Comparator<int[]> com = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };

        PriorityQueue<int[]> q = new PriorityQueue<>(com);
        q.add(new int[] {start, 0});
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll(); // {현재도시, 현재비용}
            if (vis[temp[0]]) {
                continue;
            }

            vis[temp[0]] = true;

            for (int i = 0; i < city[temp[0]].size(); i++) {
                int end = city[temp[0]].get(i)[0];
                int fee = city[temp[0]].get(i)[1];

                if (distance[end] > distance[temp[0]] + fee) {
                    distance[end] = distance[temp[0]] + fee;
                    q.add(new int[] {end, distance[end]});
                }
            }
        }
    }
}
