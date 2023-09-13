import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] arr;
    static int[][] seat;
    static int[][] like;
    static int N;
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seat = new int[N+1][N+1];
        arr = new int[N*N+1];
        like = new int[N*N+1][4];

        for (int i = 1; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i < arr.length; i++) {
			likeCount(i);
		}
        
        for (int i = 1; i < arr.length; i++) {
			happySum(i);
		}
        
        System.out.println(sum);
    }
    
    public static void likeCount(int stuNum) {
    	int max = 0;
    	int[][] temp = new int[N+1][N+1];
    	List<int[]> likeList = new ArrayList<>();
    	for (int i = 1; i < seat.length; i++) {
            for (int j = 1; j < seat[0].length; j++) {
            	if(seat[i][j]!=0) {
            		continue;
            	}
            	
            	for (int d = 0; d < dr.length; d++) {
					int ni = i + dr[d];
					int nj = j + dc[d];
					
					for (int k = 0; k < like[stuNum].length; k++) {
						if (boundaryCheck(ni, nj) && seat[ni][nj] == like[stuNum][k]) {
							temp[i][j]++;
						}
					}
				}
            	max = Math.max(max, temp[i][j]);
            }
        }

    	for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp.length; j++) {
				if (max == temp[i][j] && seat[i][j]==0) {
					likeList.add(new int[] {i,j});
				}
			}
		}
    	
    	if (likeList.size()>=2) {
			emptySeat(stuNum, likeList);
		}
    	else {
    		seat[likeList.get(0)[0]][likeList.get(0)[1]] = arr[stuNum];
    	}
    }
    
    public static void emptySeat(int stuNum, List<int[]> likeList ) {
    	int[] temp = new int[likeList.size()];
    	int max = 0;
    	List<int[]> emptyList = new ArrayList<>();
    	
    	for (int i = 0; i < likeList.size(); i++) {
    		int r = likeList.get(i)[0];
    		int c = likeList.get(i)[1];
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (boundaryCheck(nr, nc) && seat[nr][nc] == 0) {
					temp[i]++;
				}
			}
			max = Math.max(max, temp[i]);
		}
    	
    	for (int i = 0; i < temp.length; i++) {
			if (temp[i] == max) {
				emptyList.add(likeList.get(i));
			}
		}
    	
    	seat[emptyList.get(0)[0]][emptyList.get(0)[1]] = arr[stuNum];
    } 
    
    public static void happySum(int stuNum) {
    	for (int i = 1; i < seat.length; i++) {
			for (int j = 1; j < seat.length; j++) {
				int count = 0;
				if (seat[i][j] != arr[stuNum]) {
					continue;
				}
				for (int d = 0; d < dr.length; d++) {
					int ni = i + dr[d];
					int nj = j + dc[d];
					
					for (int k = 0; k < like[stuNum].length; k++) {
						if (boundaryCheck(ni, nj) && seat[ni][nj] == like[stuNum][k]) {
							count++;
						}
					}
				}
				
				if (count == 0) {
					sum += 0;
				} else if (count == 1) {
					sum += 1;
				} else if (count == 2) {
					sum += 10;
				} else if (count == 3) {
					sum += 100;
				} else {
					sum += 1000;
				}
			}
		}
    }
    
    public static boolean boundaryCheck(int ni, int nj) {
    	if (ni>=1 && nj>=1 && ni<seat.length && nj<seat.length) {
			return true;
		}
    	return false;
    }
}