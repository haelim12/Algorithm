import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<List<int[]>> unionList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        while (true) {
            boolean move = false; // 인구 이동이 발생했으면 true
            unionList = new ArrayList<>();
            boolean[][] vis = new boolean[N][N];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (!vis[i][j]) {
                    	List<int[]> country = new ArrayList<>();
                    	country.add(new int[] {i,j});
                        bfs(i,j,country,vis);

                        if (country.size() > 1) {
                            move = true;
                            unionList.add(country);
                        }
                    }
                }
            }

            if (!move) {
                break;
            }

            for (int i = 0; i < unionList.size(); i++) {
                int total = 0;
                for (int j = 0; j < unionList.get(i).size(); j++) {
                    int[] temp = unionList.get(i).get(j);
                    total += map[temp[0]][temp[1]];
                }
                int newSum = total / unionList.get(i).size();
                for (int j = 0; j < unionList.get(i).size(); j++) {
                    int[] temp = unionList.get(i).get(j);
                    map[temp[0]][temp[1]] = newSum;
                }
            }
            count++;
        }
        System.out.println(count);
    }

    public static void bfs(int i, int j, List<int[]> country, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int d = 0; d < dr.length; d++) {
                int ni = temp[0] + dr[d];
                int nj = temp[1] + dc[d];

                if (ni>=0 && ni<map.length && nj>=0 && nj<map.length && !vis[ni][nj]) {
                    int diff = Math.abs(map[temp[0]][temp[1]]-map[ni][nj]);
                    if (diff>= L && diff<=R) {
                        q.add(new int[] {ni,nj});
                        vis[ni][nj] = true;
                        country.add(new int[] {ni,nj});
                    }
                }
            }
        }

    }
}