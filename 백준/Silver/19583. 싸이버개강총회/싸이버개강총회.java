import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        
        int answer = 0;
        String chat;
        while ((chat= br.readLine()) != null) {
            if (S.compareTo(chat.split(" ")[0]) >= 0) {
                start.add(chat.split(" ")[1]);
            } else if (E.compareTo(chat.split(" ")[0]) <= 0
                && Q.compareTo(chat.split(" ")[0]) >= 0) {
                end.add(chat.split(" ")[1]);
            }
        }

        for (String temp : end) {
            if (start.contains(temp)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
