import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];  
            }
        });
        
        int end = routes[0][1];
        int count = 1;
        
        for(int[] r: routes) {
            if(end >= r[0]) {
                continue;
            } else if (end < r[0]) {
                count++;
                end = r[1];
            }
        }
        return count;
    }
}