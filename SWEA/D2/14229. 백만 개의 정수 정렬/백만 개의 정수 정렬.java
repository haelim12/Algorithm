import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = arr.length;

		mergeSort(arr, 0, N-1);

		System.out.println(arr[500000]);
		
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		for(int j=0; j<n2; j++) {
			R[j] = arr[m+1 + j];
		}
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i < n1 && j < n2) {
			if(L[i] < R[j]) // L의 값이 더 작다면
				arr[k++] = L[i++]; // L을 옮긴다
			else
				arr[k++] = R[j++];
		}
				
		for(; i<n1; i++) {
			arr[k++] = L[i];
		}
		
		for(; j<n2; j++) {
			arr[k++] = R[j];
		}
	}
}