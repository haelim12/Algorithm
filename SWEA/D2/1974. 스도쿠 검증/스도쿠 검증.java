import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[][] map = new int[9][9];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            boolean check = true;
            // 가로 확인
            label : for (int i = 0; i < map.length; i++) {
                List<Integer> nums = new ArrayList<>();
                for (int j = 0; j < map[0].length; j++) {
                    if (!nums.contains(map[i][j])) {
                        nums.add(map[i][j]);
                    } else {
                        check = false;
                        break label;
                    }
                }
            }

            // 세로 확인
            label : for (int j = 0; j < map[0].length; j++) {
                List<Integer> nums = new ArrayList<>();
                for (int i = 0; i < map.length; i++) {
                    if (!nums.contains(map[i][j])) {
                        nums.add(map[i][j]);
                    } else {
                        check = false;
                        break label;
                    }
                }
            }

            // 네모 확인
            label : for (int i = 0; i < map.length; i+=3) {
                for (int j = 0; j < map[0].length; j+=3) {
                    List<Integer> nums = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (!nums.contains(map[i+k][j+l])) {
                                nums.add(map[i+k][j+l]);
                            } else {
                                check = false;
                                break label;
                            }
                        }
                    }
                }
            }

            if (check) {
                System.out.printf("#%d 1\n", tc);
            } else {
                System.out.printf("#%d 0\n", tc);
            }
        }
    }
}
