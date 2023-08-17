import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        String[][] arr = new String[N][2];
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            arr[i][0] = st2.nextToken();
//            arr[i][1] = st2.nextToken();
            map.put(st2.nextToken(), st2.nextToken());
        }

//        for (int i = 0; i < M; i++) {
//            String find = br.readLine();
//            label : for (int j = 0; j < N; j++) {
//                if (arr[j][0].equals(find)) {
//                    System.out.println(arr[j][1]);
//                    break label;
//                }
//            }
//        }
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
