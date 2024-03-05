import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            int count = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= arr.length; j++) {
                if(count==0) {
                    if(arr[j]==0) {
                        arr[j] = i;
                        break;
                    }
                }
                else {
                    if(arr[j]==0) {
                        count--;
                    }
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
