import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> notHeard = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            notHeard.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHeard.containsKey(name))
                notHeard.put(name, 2);
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> pair: notHeard.entrySet()) {
            if (pair.getValue() == 2) {
                list.add(pair.getKey());
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
