import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] dr = {1,1,-1,-1}; // 우하향부터 시계방향
	static int[] dc = {1,-1,-1,1};
	static int[][] map;
	static int max; // 최댓값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			max = -1;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					dfs(i,j,i,j,0,0,new ArrayList<Integer>());
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	
	public static void dfs(int sr, int sc, int cr, int cc, int d, int count, ArrayList<Integer> list) {
		// 기저조건
        if(count!=0 && sr == cr && sc == cc && d == 3) {
            // 출발점으로 돌아온 경우
            if (max < count)
                max = count;
        }
        
        // 유도조건
        int nr = cr + dr[d];
        int nc = cc + dc[d];
        
        if(nr >= 0 && nr < N && nc >=0 && nc < N &&
                !list.contains(map[nr][nc])) {
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int i: list) list2.add(i);
            list2.add(map[nr][nc]);
            dfs(sr, sc, nr, nc, d, count+1, list2);
        }
         
        // 2. 꺽어서 가는 경우 (d+1)방향
        if(d < 3) {
            nr = cr + dr[d+1];
            nc = cc + dc[d+1];
            if(nr >= 0 && nr < N && nc >=0 && nc < N &&
                !list.contains(map[nr][nc])) {
                ArrayList<Integer> list3 = new ArrayList<>();
                for(int i: list) list3.add(i);
                list3.add(map[nr][nc]);
                dfs(sr, sc, nr, nc, d+1, count+1, list3);
            }
        }
	}
}