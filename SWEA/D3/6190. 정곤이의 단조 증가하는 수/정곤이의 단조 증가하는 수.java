import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            long max = Integer.MIN_VALUE;
            boolean ismax = false;
            for (int i = 0; i < arr.length-1; i++) {
                label : for (int j = i+1; j < arr.length; j++) {
                    String temp = String.valueOf(arr[i]*arr[j]);
//                    System.out.println(temp);
                    int[] nums = new int[temp.length()];
                    boolean check = true;
                    for (int k = 0; k < nums.length; k++) {
                        nums[k] = temp.charAt(k) - '0';
                    }
//                    System.out.println(Arrays.toString(nums));
                    for (int k = 1; k < nums.length; k++) {
                        if (nums[k] < nums[k-1]) {
                            check = false;
                            continue label;
                        }
                    }
                    ismax = true;
                    max = Math.max(max, (long) arr[i]*arr[j]);
//                    System.out.println(max);
//                    System.out.println();
                }
            }
            if (ismax) {
                System.out.printf("#%d %d\n", tc, max);
            } else {
                System.out.printf("#%d -1\n", tc);
            }
        }
    }
}
