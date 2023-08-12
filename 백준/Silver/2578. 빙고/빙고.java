import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];
        int[] nums = new int[25];
        int[][] bingo = new int[5][5];
        int win = 0;

        // 빙고 받기
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(nums));

        int idx = 0;

        // 숫자 찾아가면서 그 위치에 1
        label : while (idx < 25) {
            label2 : for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == nums[idx]) {
                        bingo[i][j] = 1;
//                        System.out.println(i + " "+ j);
                        break label2;
                    }
                }
            }
            // 빙고 돌면서 가로, 세로, 대각선 합이 5가 될 경우 멈추고 num 출력
            int count = 0; // count 가 5면 빙고
            win =0;
            
            for (int i = 0; i < bingo.length; i++) {
                if (bingo[i][0] == 1) {
                    count = 0;
                    for (int j = 0; j < 5; j++) {
                        if (bingo[i][j] == 1) {
                            count++;
                        }
                    }
                    if (count==5) {
                        win++;
                    }
                }
            }

            for (int j = 0; j < bingo.length; j++) {
                if (bingo[0][j] == 1) {
                    count = 0;
                    for (int i = 0; i < 5; i++) {
                        if (bingo[i][j] == 1) {
                            count++;
                        }
                    }
                    if (count==5) {
                        win++;
                    }
                }
            }

            // 대각선
            if (bingo[0][0] == 1) {
                count = 0;
                for (int d = 0; d < 5; d++) {
                    if (bingo[d][d] == 1) {
                        count++;
                    }
                }
                if (count == 5) {
                    win++;
                }
            }

            if (bingo[0][4] == 1){
                count = 0;
                for (int d = 0; d < 5; d++) {
                    if (bingo[d][4-d] == 1) {
                        count++;
                    }
                }
                if (count==5) {
                    win++;
                }
            }
            if (win >= 3){
                break label;
            }
            idx++;
        }
        System.out.println(idx+1);
    }
}

