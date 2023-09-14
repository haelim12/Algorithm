import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] play;
	static int[] playerArr;
	static boolean[] vis;
	static int inning = 1;
	static int max_score = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		play = new int[N+1][10];
		playerArr = new int[10];
		vis = new boolean[10];
		
		playerArr[4] = 1;
		vis[1] = true;
		
		for (int i = 1; i < play.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < play[0].length; j++) {
				play[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select(1);
		
		System.out.println(max_score);
		
	}
	public static void select(int idx) {
		if (idx == playerArr.length) {
//			System.out.println(Arrays.toString(playerArr));
			playGame();
			return;
		}
		
		if (idx == 4) {
			select(idx+1);
		}
		else {
			for (int i = 2; i < play[0].length; i++) {
				if (!vis[i]) {
					playerArr[idx] = i;
					vis[i] = true;
					select(idx+1);
					vis[i] = false;
				}
			}
		}
	}
	
	public static void playGame() {
		int out = 0;
		inning = 1;
		int player = 1;
		boolean[] base = new boolean[4];
		int score = 0;
		
		while (inning <= N) {
			
			switch (play[inning][playerArr[player]]) {
				case 0:
					out++;
					if (out == 3) {
						Arrays.fill(base, false);
						inning++;
						out = 0;
					}
					break;
				case 1:
					for (int i = 3; i >= 1; i--) {
						if (i == 3 && base[i]) {
							score++;
							base[i] = false;
						}
						else if (base[i]) {
							base[i+1] = true;
							base[i] = false;
						}
					}
					base[1] = true;
					break;
				case 2:
					for (int i = 3; i >= 1; i--) {
						if ((i == 3 || i == 2) && base[i]) {
							score++;
							base[i] = false;
						}
						else if (base[i]) {
							base[i+2] = true;
							base[i] = false;
						}
					}
					base[2] = true;
					break;
				case 3:
					for (int i = 3; i >= 1; i--) {
						if (base[i]) {
							score++;
							base[i] = false;
						}
					}
					base[3] = true;
					break;
				case 4:
					for (int i = 3; i >= 1; i--) {
						if (base[i]) {
							score++;
							base[i] = false;
						}
					}
					score++;
					break;
			}
			player++;
			if (player == playerArr.length) {
				player = 1;
			}
		}
		max_score = Math.max(max_score, score);
	}
}