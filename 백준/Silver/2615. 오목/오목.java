import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[20][20];

        for (int i = 1; i < arr.length; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            for (int j = 1; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bwini = 0;
        int bwinj = 0;
        int wwini = 0;
        int wwinj = 0;
        boolean blackWin = false;
        boolean whiteWin = false;
        
        // 검은돌 1 흰돌 2
        // 검은돌부터
        label : for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int count = 0;
                if (arr[i][j] == 1) {
                    // 가로탐색
                    if (j==0 || arr[i][j-1] != 1) {
                        for (int d = 0; d < 6; d++) {
                            if (j + d < 20 && arr[i][j + d] == 1) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            blackWin = true;
                            bwini = i;
                            bwinj = j;
//                            System.out.println("검은돌 가로");
                            break label;
                        }
                    }

                    // 세로탐색
                    count = 0;
                    if (i==0 || arr[i-1][j] != 1) {
                        for (int d = 0; d < 6; d++) {
                            if (i + d < 20 && arr[i + d][j] == 1) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            blackWin = true;
                            bwini = i;
                            bwinj = j;
//                            System.out.println("검은돌 세로");
                            break label;
                        }
                    }

                    // 우하향 탐색
                    count = 0;
                    if (i==0 || j==0 || arr[i-1][j-1] != 1) {
                        for (int d = 0; d < 6; d++) {
                            if (i + d < 20 && j + d < 20 && arr[i + d][j + d] == 1) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            blackWin = true;
                            bwini = i;
                            bwinj = j;
//                            System.out.println("검은돌 우하향");
                            break label;
                        }
                    }

                    // 좌하향 탐색
                    int tempi = 0;
                    int tempj = 0;
                    count = 0;
                    if (i==0 || j == 19 || arr[i-1][j+1] != 1) {
                        for (int d = 0; d < 6; d++) {
                            if (i + d < 20 && j - d >= 1 && arr[i + d][j - d] == 1) {
                                count++;
                            } else {
                                tempi = i + d;
                                tempj = j - d;
                                break;
                            }
                        }
                        if (count == 5) {
                            blackWin = true;
                            bwini = tempi-1;
                            bwinj = tempj+1;
//                            System.out.println("검은돌 좌하향");
                            break label;
                        }
                    }
                }
            }
        }
//        System.out.println(blackWin);

        // 흰돌 탐색
        label : for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int count = 0;
                if (arr[i][j] == 2) {
                    // 가로탐색
                    if ( j==0 || arr[i][j-1] != 2) {
                        for (int d = 0; d < 6; d++) {
                            if (j+d<20 && arr[i][j+d] == 2) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            whiteWin = true;
                            wwini = i;
                            wwinj = j;
//                            System.out.println("흰돌 가로");
                            break label;
                        }
                    }

                    // 세로탐색
                    count = 0;
                    if (i==0 || arr[i-1][j] != 2){
                        for (int d = 0; d < 6; d++) {
                            if (i+d<20 && arr[i+d][j] == 2) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            whiteWin = true;
                            wwini = i;
                            wwinj = j;
//                            System.out.println("흰돌 세로");
                            break label;
                        }
                    }

                    // 우하향 탐색
                    count = 0;
                    if (i==0 || j==0 || arr[i-1][j-1] != 2) {
                        for (int d = 0; d < 6; d++) {
                            if (i+d<20 && j+d<20 && arr[i+d][j+d] == 2) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            whiteWin = true;
                            wwini = i;
                            wwinj = j;
//                            System.out.println("흰돌 우하향");
                            break label;
                        }
                    }

                    // 좌하향 탐색
                    count = 0;
                    if (i==0 || j==19 || arr[i-1][j+1] != 2){
                        int tempi = 0;
                        int tempj = 0;
                        for (int d = 0; d < 6; d++) {
                            if (i+d<20 && j-d>=1 && arr[i+d][j-d] == 2) {
                                count++;
                            } else {
                                tempi = i+d;
                                tempj = j-d;
                                break;
                            }
                        }
                        if (count == 5) {
                            whiteWin = true;
                            wwini = tempi-1;
                            wwinj = tempj+1;
//                            System.out.println("흰돌 좌하향");
                            break label;
                        }
                    }
                }
            }
        }
//        System.out.println(whiteWin);

        if ((whiteWin && blackWin) || (!whiteWin && !blackWin)) {
            System.out.println(0);
        } else if (whiteWin && !blackWin) {
            System.out.println(2);
            System.out.println(wwini + " " + wwinj);
        } else if (blackWin && !whiteWin) {
            System.out.println(1);
            System.out.println(bwini + " " + bwinj);
        }
    }
}
