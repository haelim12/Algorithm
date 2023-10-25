import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new String[12][6];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
//            System.out.println(Arrays.toString(map[i]));
        }

        while (true) {
            boolean check = true;
            for (int i = map.length-1; i >= 0; i--) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j].equals(".")) {
                        continue;
                    }
                    if (bfs(i, j, map[i][j])) {
                        check = false;
                    }
                }
            }
            if (check) {
//                System.out.println(count);
                break;
            }
//            printMap();
            gravity();
//            System.out.println();
//            printMap();
            count++;
        }

        System.out.println(count);
    }
    static boolean bfs(int i, int j, String color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        boolean[][] vis = new boolean[map.length][map[0].length];
        vis[i][j] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
//            System.out.println("");
            int[] arr = q.poll();
            for (int d = 0; d < dr.length; d++) {

                int ni = arr[0] + dr[d];
                int nj = arr[1] + dc[d];

                if (ni>=0 && ni<map.length && nj>=0 && nj<map[0].length
                        && map[ni][nj].equals(color) && !vis[ni][nj]) {
                    q.add(new int[] {ni, nj});
                    vis[ni][nj] = true;
                    cnt++;
                }
            }
        }
        if (cnt >= 4) {
            for (int k = 0; k < vis.length; k++) {
                for (int l = 0; l < vis[0].length; l++) {
                    if (vis[k][l]) {
                        map[k][l] = ".";
                    }
                }
            }
            return true;
        }
        return false;
    }
    static void gravity() {
        String [][] newMap = new String[map.length][map[0].length];
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[0].length; j++) {
                newMap[i][j] = ".";
            }
        }

        for (int k = 0; k < map[0].length; k++) {
            int index = map.length-1;
            for (int i = map.length-1; i >=0 ; i--) {
                if (!map[i][k].equals(".")) {
                    newMap[index][k] = map[i][k];
                    index--;
                }
            }
        }

        map = newMap;
    }
//    static void printMap(){
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//    }
}
