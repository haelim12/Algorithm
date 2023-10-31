import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] building;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        building = new int[N];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < building.length; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < building.length; i++) {
            connect(i);
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
    public static void connect(int index) {
        count = 0;
        double slope = 0;
        // 왼쪽
        for (int i = index-1; i>=0 ; i--) {
            double temp = (double) (building[index] - building[i]) / (index - i);

            if (i == index-1) { // 바로 옆 건물
                slope = temp;
                count++;
            } else if (slope > temp) {
                count++;
                slope = temp;
            }
        }

        slope = 0;
        // 오른쪽
        for (int i = index+1; i < building.length; i++) {
            double temp = (double) (building[index] - building[i]) / (index - i);

            if (i == index+1) {
                slope = temp;
                count++;
            } else if (slope < temp) {
                count++;
                slope = temp;
            }
        }
    }
}
