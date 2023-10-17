import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int g = gcd(a,b);
        int l = (a*b) / g;

        System.out.println(g);
        System.out.println(l);
    }
    
    public static int gcd(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
