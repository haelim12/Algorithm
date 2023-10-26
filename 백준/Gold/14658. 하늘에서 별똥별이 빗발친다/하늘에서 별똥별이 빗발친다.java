import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, K;
    static int[][] map;
    static List<int[]> stars;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[i][0] = x;
            map[i][1] = y;
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < map.length; i++) {
            stars = new ArrayList<>();
            int temp = map[i][0];
            stars.add(new int[]{map[i][0], map[i][1]});

            for (int j = i + 1; j < map.length; j++) {
                if (map[j][0] >= temp && map[j][0] <= temp + L) {
                    stars.add(new int[]{map[j][0], map[j][1]});
                } else {
                    break;
                }
            }
            trampoline(i);
        }
        System.out.println(min);
    }

    static void trampoline(int i) {

        Collections.sort(stars, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        for (int j = 0; j < stars.size(); j++) {
            int temp = stars.get(j)[1];
            int count = 0;
            for (int k = 0; k < stars.size(); k++) {
                if (stars.get(k)[1]>= temp && stars.get(k)[1] <= temp+L) {
                    count++;
//                    System.out.println("count 올라갈 떄 언떤 값이 출력되니?" + Arrays.toString(stars.get(k)));
                }
            }
//            for (int k = 0; k < stars.size(); k++) {
//                System.out.println(Arrays.toString(stars.get(k)));
//            }
//            System.out.println(count);
//            System.out.println();
            min = Math.min(min, K-count);
        }
    }
}
