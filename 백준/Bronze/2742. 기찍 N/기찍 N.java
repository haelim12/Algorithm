import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = n; i > 0; i--) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
