import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int test = 0;
        
        String[] word = {"aya", "ye", "woo", "ma"};
        // String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for (int i = 0; i < babbling.length; i++) {
            // for (int j = 0; j < repeat.length; j++) {
            //     if (babbling[i].contains(repeat[j])) {
            //         break;
            //     }
            // }
            if (babbling[i].contains("ayaaya") ||
                babbling[i].contains("yeye") ||
                babbling[i].contains("woowoo") ||
                babbling[i].contains("mama")) {
                    continue;
            }
            
            // for (int j = 0; j < word.length; j++) {
            //     babbling[i].replace(word[j],"");
            // }
            
            babbling[i] = babbling[i].replace("aya", "x");
            babbling[i] = babbling[i].replace("ye", "x");
            babbling[i] = babbling[i].replace("woo", "x");
            babbling[i] = babbling[i].replace("ma", "x");
            
            
            babbling[i] = babbling[i].replace("x", "");
            
            if(babbling[i].length() == 0) {
                answer ++;
            }
        }
        return answer;
    }
}