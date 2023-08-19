import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        List<Integer> arr= new ArrayList<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
//            arr.add(Integer.parseInt(st.nextToken()));
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortArr = arr.clone();

        Arrays.sort(sortArr);

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < sortArr.length; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], count++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
