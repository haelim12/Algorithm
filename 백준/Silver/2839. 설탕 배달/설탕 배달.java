import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sugar = 0;

        if (N % 5 == 0) { // 5로 나누어 떨어질 때
            System.out.println(N / 5);
        } else { // 5로 나누어 떨어지지 않을 때
            while (N>0) {
                N -= 3; // 3짜리 설탕
                sugar += 1;

                if (N % 5 == 0) {
                    sugar += N/5;
                    System.out.println(sugar);
                    break;
                } else if (N == 1 || N == 2) {
                    System.out.println(-1);
                } else if (N == 0) {
                    System.out.println(sugar);
                    break;
                }
            }
        }
    }
}
