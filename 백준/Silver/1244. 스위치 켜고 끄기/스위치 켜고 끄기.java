import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		
		for (int m = 0; m < M; m++) {
			if (sc.nextInt() == 1) { // 남학생
				int num = sc.nextInt();
				for (int i = 1; i < arr.length; i++) {
					if (i % num == 0) {
						if (arr[i] == 1) {
							arr[i] = 0;
						} else {
							arr[i] = 1;
						}
					}
				}
//				System.out.println("뭐지?");
				
			} else { // 여학생
				int num = sc.nextInt();
				
				if (arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}
//				System.out.println("여긴오니?");
				int change = 1;
				label : while (true) {
					if (num-change >= 1 && num+change < arr.length && arr[num-change] == arr[num+change]) {
						if (arr[num-change] == 1) {
							arr[num-change] = arr[num+change] = 0;
						} else {
							arr[num-change] = arr[num+change] = 1;
						}
//						System.out.println("되고있나?");
					} else {
//						System.out.println("브레이크 하나?");
						break label;
					}
					change++;
//					System.out.println(change);
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if (i%20 == 0) {
				System.out.print(arr[i]);
				System.out.println();
			} else {
				System.out.print(arr[i] + " ");
			}
		}
	}
}