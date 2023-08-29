import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] check;
    static int N, M;
    static boolean[][] connect;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 사람 수
        M = sc.nextInt(); // 파티 수

        check = new boolean[N+1]; // 아는 사람 있을 때 true
        int know = sc.nextInt();
        if (know == 0) { // 아는 사람이 없을 경우 파티 수 출력
            System.out.println(M);
            return;
        }
        for (int i = 0; i < know; i++) {
            check[sc.nextInt()] = true; // 아는 사람 true 처리
        }

        connect = new boolean[N+1][N+1]; // 연결 되는 배열 만들기
        int[][] party = new int[M][N]; // 파티 배열
        for (int i = 0; i < M; i++) { // 파티수 M번
            int person = sc.nextInt();
            party[i] = new int[person];
            party[i][0] = sc.nextInt();
//            System.out.println(party[i][0]);
            for (int j = 1; j < person; j++) {
                party[i][j] = sc.nextInt();
//                System.out.println(party[i][j]);
                // 앞에 나온 번호들이랑 연결
                connect[party[i][j-1]][party[i][j]] = connect[party[i][j]][party[i][j-1]] = true;
            }
//            System.out.println();
        }

        // 여기서 문제
        // party 하나하나 다 돌면서 계속 봐줘야됨
        for (int m = 1; m <= N; m++) {
            if (check[m]) {
                dfs(m);
            }
        }

        int count= 0;
        for (int i = 0; i < M; i++) {
            if (!check[party[i][0]]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int index) {
        for (int i = 1; i <= N ; i++) {
            if (connect[index][i] && !check[i]) {
                check[i] = true;
//                party[i] = true;
                dfs(i);
            }
        }
//        System.out.println(Arrays.toString(check));
    }
}