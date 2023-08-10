import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[N][M];
		
		// 배열에 넣기
		for (int i = 0; i < N; i++) {
			String[] s = sc.nextLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		// 1인 경우의 인덱스 값 넣을 큐
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {0,0,1}); // 맨 처음 인덱스 미리 넣어놓기 + 1 => 앞에거랑 같은 temp[2] 
		
		// 방문했을 경우 true로 바꾸기
		boolean[][] visited = new boolean[N][M];
		
		// temp[2] 가 1일 경우 count++
		int count = 0;
		
		// 
		boolean check = false;
		
		while (!q.isEmpty()) { // 큐가 빌 때까지 ....
			// 큐 맨 위 인덱스 뽑기
			int[] temp = q.poll();
						
			if (temp[2] == 1) {
				count++;
				check = true;
			}
			
			if (temp[0] == N-1 && temp[1] == M-1) {
				break;
			}
			
			// 사방탐색
			for (int k = 0; k < 4; k++) {
				int ni = temp[0] + dr[k];
				int nj = temp[1] + dc[k];
				int nk = 3;
				// 0<= ni, nj < N,M 이고 방문하지 않았을 경우
				if (ni>=0 && nj>=0 && ni<N && nj<M && arr[ni][nj] == 1 && !visited[ni][nj]) {
					
					// check 가 true일 때, nk=1로 바꿔주고 check 초기화
					if (check) {
						nk = 1;
						check = false;
					}
					// 새로운 인덱스 큐에 넣고, 방문 true
					q.offer(new int[] {ni,nj,nk});
					visited[ni][nj] = true;
				}
			}
		}
		System.out.println(count);
	}
}