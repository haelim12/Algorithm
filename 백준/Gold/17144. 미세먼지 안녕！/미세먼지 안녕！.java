import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    int[][] room = new int[N][M];
    
    int vac1i = 0;
    int vac1j = 0;
    int vac2i = 0;
    int vac2j = 0;

    for (int i = 0; i < room.length; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < room[0].length; j++) {
            room[i][j] = Integer.parseInt(st.nextToken());
            if (room[i][j] == -1) {
                if (vac1i == 0) {
                    vac1i = i;
                    vac1j = j;
                } else {
                    vac2i = i;
                    vac2j = j;
                }
            }
        }
    }

    int time = 0;
    // 상 하 좌 우
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    while (time < T) {
    	time++;
    	int[][] newRoom = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] != 0 && room[i][j] != -1) {
                    q.add(new int[] {i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int spreadcnt = 0;
            for (int d = 0; d < dc.length; d++) {
                int ni = temp[0] + dr[d];
                int nj = temp[1] + dc[d];
                if (ni >=0 && ni < N && nj >= 0 && nj < M && room[ni][nj] != -1) {
                    newRoom[ni][nj] += room[temp[0]][temp[1]] / 5;
                    spreadcnt += 1;
                }
                
            }
            room[temp[0]][temp[1]] -= spreadcnt * (room[temp[0]][temp[1]] / 5);
            newRoom[temp[0]][temp[1]] += room[temp[0]][temp[1]];
        }

        // 공기순환
        int[][] newArr = new int[N][M];


        for (int j = 1; j < M-1; j++) {
            newArr[vac1i][j+1] = newRoom[vac1i][j];
        }
        
        for (int i = vac1i; i >= 1 ; i--) {
            newArr[i-1][M-1] = newRoom[i][M-1];
        }
        for (int j = 1; j < M; j++) {
            newArr[0][j-1] = newRoom[0][j];
        }
        for (int i = 0; i < vac1i; i++) {
            if (i+1 == vac1i) {
                continue;
            } else {
                newArr[i + 1][0] = newRoom[i][0];
            }
        }
        
//        for (int i = 0; i < newArr.length; i++) {
//			System.out.println(Arrays.toString(newArr[i]));
//		}
//        System.out.println();

        for (int j = 1; j < M-1; j++) {
            newArr[vac2i][j+1] = newRoom[vac2i][j];
        }
        for (int i = vac2i; i < N-1 ; i++) {
            newArr[i+1][M-1] = newRoom[i][M-1];
        }
        for (int j = 1; j < M; j++) {
            newArr[N-1][j-1] = newRoom[N-1][j];
        }
        for (int i = N-1; i >= vac2i; i--) {
            newArr[i - 1][0] = newRoom[i][0];
        }
        
        for (int i = 1; i < vac1i; i++) {
			for (int j = 1; j < newArr[0].length-1; j++) {
				newArr[i][j] = newRoom[i][j] ;
			}
		}
        
//      for (int i = 0; i < newArr.length; i++) {
//			System.out.println(Arrays.toString(newArr[i]));
//		}
//      System.out.println();
        
        for (int i = vac2i+1; i < N-1; i++) {
			for (int j = 1; j < newArr[0].length-1; j++) {
				newArr[i][j] = newRoom[i][j] ;
			}
		}
        
        newArr[vac1i][vac1j] = -1;
        newArr[vac2i][vac2j] = -1;

        room = newArr;
//        for (int i = 0; i < N ; i++) {
//            System.out.println(Arrays.toString(room[i]));
//        }
//        System.out.println();
    }

    int sum = 0;
    for (int i = 0; i < N ; i++) {
        for (int j = 0; j < M; j++) {
            if (room[i][j] >= 1) {
                sum += room[i][j];
            }
        }
    }
    
//    for (int i = 0; i < N ; i++) {
//        System.out.println(Arrays.toString(room[i]));
//    }

    System.out.println(sum);
}
}