import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> garo = new ArrayList<>();
		List<Integer> sero = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int d = sc.nextInt();
			list.add(d);
			if (dir == 1 || dir == 2) {
				garo.add(d);
			} else {
				sero.add(d);
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		int max_garo = garo.get(garo.size()-1);
		int max_sero = sero.get(sero.size()-1);
		
		while(true) {
			if (max_garo == list.get(0) && max_sero == list.get(list.size()-1)) {
				break;
			} else if (max_sero == list.get(0) && max_garo == list.get(list.size()-1)) {
				break;
			} 
			else {
				list.add(list.get(0));
				list.remove(0);
			}
		}
		
		int size = max_garo * max_sero;
		int empty = list.get(2) * list.get(3);
		
		int farm = size - empty;
		
		System.out.println(farm * N);
		
	
	}
}