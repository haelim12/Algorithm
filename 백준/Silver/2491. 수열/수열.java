import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        boolean up = false;
        boolean down = false;
        int upcount = 1;
        int downcount = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1]) { // 숫자가 커질 때
                if (!up) {
                    up = true;
                    down = false;
                    max = Math.max(max, downcount);
                    downcount = 1;
                }
                downcount = 1;
                upcount++;
            } else if (arr[i] > arr[i+1]) { // 숫자가 작아질 때
                if (!down) {
                    down = true;
                    up = false;
                    max = Math.max(max, upcount);
                    upcount = 1;
                }
                upcount = 1;
                downcount++;
            } else {
                downcount++;
                upcount++;
            }
//            System.out.println(upcount + " " + downcount);
        }
        max = Math.max(max, upcount);
        max = Math.max(max, downcount);
        System.out.println(max);
    }
}
