import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target 이 words 에 포함 되어 있는지 확인
        boolean checkTarget = false;
        for (String word : words) {
            if(word.equals(target)) {
                checkTarget = true;
                break;
            }
        }
        
        if(!checkTarget) return 0;
        
        int count = 0;
        boolean[] visited = new boolean[words.length];
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                for(int j = 0; j < words.length; j++) {
                    if(!visited[j] && changeWord(curr, words[j])) {
                        visited[j] = true;
                        
                        if(target.equals(words[j])) {
                            return count;
                        }
                        
                        queue.offer(words[j]);
                    }
                }
            }
        }
        return 0;
    }
    boolean changeWord(String curr, String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if(curr.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}