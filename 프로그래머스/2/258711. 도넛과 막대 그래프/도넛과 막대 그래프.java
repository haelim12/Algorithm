import java.util.*;

class Solution {
    static int L = 1000000;
    static int[] inArr = new int[L+1];
    static int[] outArr = new int[L+1];
    static boolean[] visited = new boolean[L+1];
    static List<Integer>[] edgeList = new ArrayList[L+1];
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        for (int i = 0; i < L+1; i++) {
            edgeList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int in = edges[i][0];
            int out = edges[i][1];
            edgeList[in].add(out);
            
            inArr[in]++;
            outArr[out]++;
        }
        
        int start = 0;
        for (int i = 1; i <= L; i++) {
            if(inArr[i] >= 2 && outArr[i] == 0) {
                start = i;
                break;
            }
        }
        answer[0] = start;
        
        for (int now : edgeList[start]) {
            int cycleCnt = findCycle(now);
            
            if(cycleCnt == 0) {
                answer[2]++;
            } else if (cycleCnt == 2) {
                answer[3]++;
            } else {
                answer[1]++;
            }
        }
        return answer;
    }
    
    public int findCycle(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        int cycleCnt = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : edgeList[now]) {
                if(visited[next]) {
                    cycleCnt++;
                    continue;
                }
                queue.add(next);
                visited[next] = true;
            }
        }
        return cycleCnt;
    }
}