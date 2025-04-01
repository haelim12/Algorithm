import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if (n > s) {
            answer = new int[] {-1};
            return answer;
        }
        
        int q = s / n;
        int r = s % n;
        
        answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = q;
        }
        
        for(int i = 0; i < r; i++) {
            answer[i]++;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}