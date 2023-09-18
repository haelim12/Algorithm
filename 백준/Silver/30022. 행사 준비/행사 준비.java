import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, A, B;
	static long[] store;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken()); // 동하 상점 A
		B = Integer.parseInt(st.nextToken()); // 지원 상점 B
		
		store = new long[N];
		long total = 0;
		for (int i = 0; i < store.length; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			total+=a;
			store[i] = b-a;
		}
		
		Arrays.sort(store);
		for (int i = 0; i < B; i++) {
			total+=store[i];
		}
		System.out.println(total);
	}
}