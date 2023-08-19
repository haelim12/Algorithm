import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] cards;
    static int[] find;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        List<Integer> cards = new ArrayList<>();
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
//            cards.add(Integer.parseInt(st.nextToken()));
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        find = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < find.length; i++) {
            find[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(cards);

        for (int i = 0; i < find.length; i++) {
            int num = find[i];
            sb.append(upper(num) - lower(num)).append(" ");

        }

        System.out.println(sb);
    }

    public static int lower(int num) {
        int low = 0;
        int high = cards.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (num <= cards[mid]) { // 찾는 숫자보다 클 경우 -> 왼쪽탐색
                high = mid;
            } else { // 작을 경우 -> 오른쪽 탐색
                low = mid + 1;
            }
        }
        return low;
    }
    public static int upper(int num) {
        int low = 0;
        int high = cards.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (num < cards[mid]) { // 찾는 숫자보다 클 경우 -> 왼쪽탐색
                high = mid;
            } else { // 작거나 같을 경우 -> 오른쪽 탐색
                low = mid + 1;
            }
        }
        return low;
    }
}
