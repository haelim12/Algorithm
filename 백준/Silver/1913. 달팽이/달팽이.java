import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 상 우 하 좌
//        int[] dr = {-1,0,1,0};
//        int[] dc = {0,1,0,-1};
        int count = 1;
        int limit = 1;

        int N = sc.nextInt();
        int find = sc.nextInt();
        int[][] arr = new int[N][N];
        StringBuilder sb = new StringBuilder();

        int row = N/2;
        int col = N/2;
        // row>=0 && row<N && col>=0 && col<N
        while(true) {
            // 상
            for (int i = 0; i < limit; i++) {
                arr[row--][col] = count++;
            }
            if (count > N*N)
                break;
            // 우
            for (int i = 0; i < limit; i++) {
                arr[row][col++] = count++;
            }
            limit++;
            // 하
            for (int i = 0; i < limit; i++) {
                arr[row++][col] = count++;
            }
            // 좌
            for (int i = 0; i < limit; i++) {
                arr[row][col--] = count++;
            }
            limit++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == find) {
                    sb.append(i+1).append(" ").append(j+1);
                }
            }
        }
        System.out.println(sb);
    }
}
