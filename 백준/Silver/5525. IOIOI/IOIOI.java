import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] word = br.readLine().toCharArray();

        int count = 0;
        int pattern = 0;

        for (int i = 1; i < M-1; i++) {
            if (word[i-1]=='I' && word[i]=='O' && word[i+1]=='I') {
                pattern++;
                if (pattern == N) {
                    count++;
                    pattern--;
                }
                i++;
            } else{
                pattern = 0;
            }
        }
        System.out.println(count);
    }
}
