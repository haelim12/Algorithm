import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int start;
	static int end;
	static boolean check = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			check = true;
			String[] str = br.readLine().split("");
			
			int start = 0; // 처음 인덱스
			int end = str.length-1; // 마지막 인덱스
			int mid = str.length/2; // 중간 인덱스
			
			checkside(start, end, mid, str);
			
			if (check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	public static void checkside (int start, int end, int mid, String[] str) {
		if (!check || start==end) {
			return;
		}
		
		int i = 1;
		int midTmp = mid;
		while (midTmp - i >= start) {
			if (str[midTmp-i].equals(str[midTmp+i])) {
				check = false;
				return;
			}
			i++;
		}
		
		// 왼쪽
		int end1 = mid-1;
		int mid1 = (start + end1) / 2;
		checkside(start, end1, mid1, str);
		
		// 오른쪽
		int start1 = mid +1;
		int mid2 = (start1 + end) / 2;
		checkside(start1, end, mid2, str);
		
	}
}