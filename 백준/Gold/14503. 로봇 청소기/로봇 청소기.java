import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < room.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < room[0].length; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		
		while(room[r][c] != 1) {
//			System.out.println(r + " " + c +" " + dir);
			if (room[r][c] == 0) {
				room[r][c] = 2;
				count ++;
			}
			for (int i = 0; i < room.length; i++) {
//				System.out.println(Arrays.toString(room[i]));
			}
			
			boolean clean = true;
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			for (int d = 0; d < dr.length; d++) {
				if (r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M && room[r+dr[d]][c+dc[d]] == 0) {
					clean = false;
					break;
				}
			}
			
			if (clean) { // 청소할 칸이 없을 경우
				if (dir == 0) { // 북
					r += 1; 
				} else if (dir == 3) { // 서
					c += 1;
				} else if (dir == 2) { // 남
					r -= 1;
				} else { // 동
					c -= 1;
				}
//				System.out.println("청소할칸이없어");
			} else { // 청소할 칸이 있을 경우
				dir = (dir+3) % 4;
				if (dir == 0) { // 북
					r -= 1;
					if (room[r][c] != 0) {
						r += 1;
					}
				} else if (dir == 3) { // 서
					c -= 1;
					if (room[r][c] != 0) {
						c += 1;
					}
				} else if (dir == 2) { // 남
					r += 1;
					if (room[r][c] != 0) {
						r -= 1;
					}
				} else { // 동
					c += 1;
					if (room[r][c] != 0) {
						c -= 1;
					}
				}
//				System.out.println("청소할칸이있다");
			}
		}
		
		System.out.println(count);
		
		
		
		
	}
}