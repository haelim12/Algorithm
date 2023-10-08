import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        HashSet nameList = new HashSet();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                nameList = new HashSet();
            } else {
                if (nameList.contains(str)) {
                    continue;
                } else {
                    nameList.add(str);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
