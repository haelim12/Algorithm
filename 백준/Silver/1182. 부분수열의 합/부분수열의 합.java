import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S==0) {
            count--;
            System.out.println(count);
        } else {
            System.out.println(count);
        }
    }

    public static void dfs(int start, int sum) {
        if (start == arr.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(start+1, sum+arr[start]);
        dfs(start+1, sum);
    }
}
