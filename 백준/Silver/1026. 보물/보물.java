import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		// A는 오름차순 정렬
		// 1. 가장 큰 값
		int K = -1;
		// 최대값 찾기
		for (int i = 0; i < N; i++) {
			if (K < A[i]) {
				K = A[i];
			}
		}
		
		int[] countA = new int[K+1];
		
		// 2. 개수 카운팅
		for (int i = 0; i < N; i++) {
			countA[A[i]]++;
		}
		
		// 3. 누적합
		for (int i = 1; i < countA.length; i++) {
			countA[i] += countA[i-1];
		}
		
		// 4. 뒤에서부터 순회 
		int[] sortA = new int[N];
		for (int i = N-1; i >= 0; i--) {
			sortA[--countA[A[i]]] = A[i];
		}
//		System.out.println(Arrays.toString(sortA));
		
		// B는 내림차순 정렬
		// 1. 가장 큰 값
		int L = -1;
		// 최대값 찾기
		for (int i = 0; i < N; i++) {
			if (L < B[i]) {
				L = B[i];
			}
		}
		
		int[] countB = new int[L+1];
		
		// 2. 개수 카운팅
		for (int i = 0; i < N; i++) {
			countB[B[i]]++;
		}
		
		// 4. 뒤에서부터 순회 
		int[] sortB = new int[N];
		int index = 0;
		for (int i = L; i >= 0; i--) {
			while(countB[i]>0) {
				sortB[index] = i;
				index++;
				countB[i]--;
			}
		}
//		System.out.println(Arrays.toString(sortB));
		
		int total = 0;
		for (int i = 0; i < sortB.length; i++) {
			total += sortA[i] * sortB[i];
		}
		
		System.out.println(total);
	}
}
