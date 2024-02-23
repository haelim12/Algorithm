import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] vis;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        vis = new boolean[N];
        ans = 0;
        back(500, 0);
        System.out.println(ans);
    }

    static void back(int sum, int idx) {
        if (idx == N) {
            ans++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!vis[i] && (sum + arr[i] - K) >= 500) {
                vis[i] = true;
                back(sum + arr[i] - K, idx + 1);
                vis[i] = false;
            }
        }
    }
}