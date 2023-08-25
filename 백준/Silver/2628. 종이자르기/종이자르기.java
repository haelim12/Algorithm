import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] arr = new int[M][N];
		
		int T = sc.nextInt();
		List<Integer> garo = new ArrayList<>();
		List<Integer> sero = new ArrayList<>();
		
		for (int t = 0; t < T; t++) {
			int dir = sc.nextInt();
			if (dir == 0) { // 가로 자르기
				garo.add(sc.nextInt());
				
			} else { // 세로 자르기
				sero.add(sc.nextInt());
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		int[] garocut = new int[garo.size()+1];
		int start = 0;
		
		for (int i = 0; i < garocut.length; i++) {
			if (i == garocut.length-1) {
				garocut[i] =N-start;
			} else {
				garocut[i] = garo.get(i)-start;
				start = garo.get(i);
			}
		}
		
//		System.out.println(Arrays.toString(garocut));
		
		int[] serocut = new int[sero.size()+1];
		start = 0;
		
		for (int i = 0; i < serocut.length; i++) {
			if (i == serocut.length-1) {
				serocut[i] =M-start;
			} else {
				serocut[i] = sero.get(i)-start;
				start = sero.get(i);
			}
		}
		
		List<Integer >total = new ArrayList<>();
		
		for (int i = 0; i < garocut.length; i++) {
			for (int j = 0; j < serocut.length; j++) {
				total.add(garocut[i]*serocut[j]);
			}
		}
		
		Collections.sort(total);
		
		System.out.println(total.get(total.size()-1));
		
	}
}