import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정점 수
        int M = Integer.parseInt(br.readLine()); // 간선 수

        arr = new int[N+1];

        // 연결정보 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[][] network = new int[M][3];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            network[i][0] = Integer.parseInt(st.nextToken());
            network[i][1] = Integer.parseInt(st.nextToken());
            network[i][2] = Integer.parseInt(st.nextToken());
        }

        // 가격 오름차순 정렬
        Comparator<int[]> com = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]- o2[2];
            }
        };

        Arrays.sort(network, com); // 오름차순 정렬

        int ans = 0;

        for (int i = 0; i < network.length; i++) {
            if (union(network[i][0], network[i][1])) { // 서로 다른 집합이었을 경우
                ans += network[i][2]; // 가격 +
            }
        }
        System.out.println(ans);
    }

    public static int find (int a) {
        if (a == arr[a]) { // 정점 a가 자신의 부모인 경우, a를 반환
            return a;
        }
        return arr[a] = find(arr[a]); // 아닐 경우, a의 부모를 찾고 반환된 부모 arr[a]에 저장
    }

    // 두 정점이 서로 다른 집합에 속해 있으면 한 집합으로 합치기
    public static boolean union (int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a != b) { // 서로 다른 집합에 속해 있을 경우
            arr[a] = b; // 합치고 true 반환
            return true;
        }
        return false;
    }
}
