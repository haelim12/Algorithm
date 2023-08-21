import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int xBound = sc.nextInt();
        int yBound = sc.nextInt();

        int startx = sc.nextInt();
        int starty = sc.nextInt();

        int time = sc.nextInt();

        int x = (startx + time) / xBound;
        int y = (starty + time) / yBound;

        int ansx = 0;
        int ansy = 0;

        if (x % 2 == 0) { // 오 -> 왼
            ansx = (startx + time) % xBound;
        } else {
            ansx = xBound - ((startx + time) % xBound);
        }

        if (y % 2 == 0) { // 위로
            ansy = (starty + time) % yBound;
        } else {
            ansy = yBound - ((starty + time) % yBound);
        }

        System.out.println(ansx + " " + ansy);

    }
}
