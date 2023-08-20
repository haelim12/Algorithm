import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] wood;
    static long start;
    static long end;
    static long M;
    static long sum;
    static long mid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        wood = new long[N];
        for (int i = 0; i < wood.length; i++) {
            wood[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(wood);
        start = 0;
        end = wood[wood.length-1];
        System.out.println(cut(start, end, M));
    }

    public static long cut(long start, long end, long M){
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for (int i = 0; i < wood.length; i++) {
                if (wood[i] > mid) {
                    sum += wood[i] - mid;
                }
            }

            if (sum >= M) { // 나무 너무 많을 때
                start = mid + 1;
            } else{ // 나무 모자랄 때
                end = mid - 1;
            }
        }
        return end;
    }
}
