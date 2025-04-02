import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {        
        char[] arr = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        for (char c : arr) {
            if (c == '(') {
                queue.offer(c);
            } else if (c == ')') {
                if(queue.isEmpty()) {
                    return false;
                }
                queue.poll();
            }
        }
        if(!queue.isEmpty()) {
            return false;
        }
        return true;
    }
}
