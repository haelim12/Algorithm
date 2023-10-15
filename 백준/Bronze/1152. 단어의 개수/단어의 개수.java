import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] word = br.readLine().split(" ");

//        System.out.println(Arrays.toString(word));
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i].equals("")) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
