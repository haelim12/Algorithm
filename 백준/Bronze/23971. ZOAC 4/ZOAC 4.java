import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int garo = 0;
        int sero = 0;

        int garo_start = 1;
        while (garo_start<=W) {
            garo++;
            garo_start+= M+1;
        }
//        System.out.println(garo);

        int sero_start = 1;
        while (sero_start<= H) {
            sero++;
            sero_start += N+1;
        }
//        System.out.println(sero);

        System.out.println(garo*sero);

    }
}
