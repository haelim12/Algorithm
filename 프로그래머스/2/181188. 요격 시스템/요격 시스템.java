import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int curr = 0;
        int count = 0;
        
        for(int i = 0; i < targets.length; i++){
            if(curr > targets[i][0]) {
                continue;
            }
            curr = targets[i][1];
            count++;
        }
        return count;
    }
}