import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] map;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        map = new List[V+1];
        distance = new int[V+1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            map[s].add(new int[] {end, dis});
        }

        dijkstra(start);

        for (int i = 1; i < map.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }


    }

    public static void dijkstra(int start) {
        boolean[] vis = new boolean[map.length];

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
            int[] temp = q.poll(); // {현재도시, 현재거리}
            int cur = temp[0];
            if (vis[cur]) {
                continue;
            }

            vis[cur] = true;

            for (int i = 0; i < map[cur].size(); i++) {
                int end = map[cur].get(i)[0];
                int fee = map[cur].get(i)[1];

                if (distance[end] > distance[temp[0]] + fee) {
                    distance[end] = distance[temp[0]] + fee;
                    q.add(new int[] {end, distance[end]});
                }
            }
        }
    }
}
