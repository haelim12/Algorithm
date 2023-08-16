import java.util.Scanner;

public class Main {
//    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        int now = 0;
        arr[now] += 1;
        int count = 0;

        while (true) {
            if (arr[now] == M) {
                break;
            }
            if (arr[now] % 2 == 1){ // 공 받은 횟수가 홀수일 때
                now = (now + L) % N;
                arr[now]++;
                count++;
            } else { // 짝수일 때
                if (now >= L) {
                    now = now - L;
                    arr[now]++;
                    count++;
                } else {
                    now = N + now - L;
                    arr[now]++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
