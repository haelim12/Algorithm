import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("add")) {
                x = Integer.parseInt(st.nextToken());
                add(x);
            } else if (str.equals("remove")) {
                x = Integer.parseInt(st.nextToken());
                remove(x);
            } else if (str.equals("check")) {
                x = Integer.parseInt(st.nextToken());
                check(x);
            } else if (str.equals("toggle")) {
                x = Integer.parseInt(st.nextToken());
                toggle(x);
            } else if (str.equals("all")) {
                all(arr);
            } else if (str.equals("empty")) {
                empty(arr);
            }
        }

        System.out.println(sb);
    }

    public static void add(int x) {
        if (!arr.contains(x))
            arr.add(x);
    }

    public static void remove(int x) {
        if (arr.contains(x))
            arr.remove(Integer.valueOf(x));
    }
    public static void check(int x) {
        if (arr.contains(x)) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void toggle(int x) {
        if (arr.contains(x)) {
            arr.remove(Integer.valueOf(x));
        } else {
            arr.add(x);
        }
    }

    public static void all(List<Integer>arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.clear();
        }
        for (int i = 1; i <= 20; i++) {
            arr.add(i);
        }
    }

    public static void empty(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.clear();
        }
    }


}
