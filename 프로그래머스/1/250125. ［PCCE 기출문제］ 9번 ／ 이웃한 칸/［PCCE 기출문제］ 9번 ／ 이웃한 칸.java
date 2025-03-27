class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        // 상 하 좌 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        String color = board[h][w];
        
        for (int i = 0; i < dr.length; i++) {
            int nh = h + dr[i];
            int nw = w + dc[i];
            
            if (nh >= 0 && nh < board.length && nw >= 0 && nw < board[0].length) {
                if (board[nh][nw].equals(color)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}