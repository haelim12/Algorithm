import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int N, M;
    static int[][] map;
    static int[] oil;
    
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        
        map = land;
        visited = new boolean[N][M];
        oil = new int[M];
        
        for (int j = 0; j < land[0].length; j++) {
            for (int i = 0; i < land.length; i++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        for (int o : oil) {
            answer = Math.max(answer, o);
        }
        return answer;
    }

    int bfs(int i, int j) {
        Set<Integer> set = new HashSet<>(); // 석유 덩어리 열 위치 저장
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        
        visited[i][j] = true;
        
        int oilCnt = 1; // 석유 덩어리 개수
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            set.add(cur[1]);
            
            for (int d = 0; d < dr.length; d++) {
                int ni = cur[0] + dr[d];
                int nj = cur[1] + dc[d];
                
                if(!checkRange(ni,nj) 
                   || map[ni][nj] == 0 
                   || visited[ni][nj]) continue;
                
                visited[ni][nj] = true;
                queue.add(new int[] {ni, nj});
                oilCnt++;
            }
        }
        for (int s : set) {
            oil[s] += oilCnt;
        }
        return oilCnt;
    }
    
    boolean checkRange(int i, int j) {
        if(i >= 0 && i < N && j >= 0 && j < M) {
            return true;
        } else {
            return false;
        }
    }
}
