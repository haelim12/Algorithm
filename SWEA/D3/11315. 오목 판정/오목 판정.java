import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            Character[][] arr = new Character[N][N];

            for (int i = 0; i < arr.length; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            boolean omok = false;
            int count = 0; // count가 5가 되면 오목

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j]=='o') {
                        // 우하향 대각선 탐색
                        count=0;
                        for (int d = 0; d < 5; d++) {
                            if (i+d<N && j+d<N && arr[i+d][j+d]=='o') {
                                count++;
                            }
                        }
                        if (count==5) {
                            omok = true;
                        }

                        // 좌하향 대각선 탐색
                        count=0;
                        for (int d = 0; d < 5; d++) {
                            if (i+d<N && j-d>=0 && arr[i+d][j-d]=='o') {
                                count++;
                            }
                        }
                        if (count==5) {
                            omok = true;
                        }

                        // 가로 탐색
                        count=0;
                        for (int d = 0; d < 5; d++) {
                            if (j+d<N && arr[i][j+d]=='o') {
                                count++;
                            }
                        }
                        if (count==5) {
                            omok = true;
                        }

                        // 세로 탐색
                        count=0;
                        for (int d = 0; d < 5; d++) {
                            if (i+d<N && arr[i+d][j]=='o') {
                                count++;
                            }
                        }
                        if (count==5) {
                            omok = true;
                        }
                    }
                }
            }

            if (omok) {
                System.out.printf("#%d YES\n", tc);
            } else {
                System.out.printf("#%d NO\n", tc);
            }
        }
    }
}
