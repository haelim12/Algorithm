import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        label : for (int i = 0; i < N; i++) {
            List<String> list = new ArrayList<>();
            String str = br.readLine();
            boolean alphabet[] = new boolean[26];
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {
                int temp = str.charAt(j) - 'a';
                if (alphabet[temp]) {
                    if (str.charAt(j) != str.charAt(j-1)) {
                        check = false;
                        break;
                    }
                } else {
                    alphabet[temp] = true;
                }
            }
            if (check) {
                count++;
            }
        }

        System.out.println(count);
    }
}
