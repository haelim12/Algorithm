import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		
		for (int i = 0; i < N; i++) {
//			String str = sc.next();
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String a = st.nextToken();
			
			
			switch (a) {
				case "push" :
//					num = sc.nextInt();
					num = Integer.parseInt(st.nextToken());
					q.offer(num);
					break;
				
				case "pop" :
					if (q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(q.poll()).append("\n");
					}
					break;
					
				case "size" :
					sb.append(q.size()).append("\n");
					break;
					
				case "empty" :
					if (q.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
					
				case "front" :
					if (q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(q.peek()).append("\n");
					}
					break;
					
				case "back" :
					if (q.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(num).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}

}
