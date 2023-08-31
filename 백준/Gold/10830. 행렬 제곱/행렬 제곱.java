import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] mat = new int[N][N];
		
		for (int i = 0; i < mat.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = multiply(mat, B);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j]%1000 + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] multiply(int[][] mat, long B) {
		int [][] newmat = new int[N][N];
		if (B==1) {
			return mat;
		}

		int[][] mat1 = multiply(mat, B/2);

		for (int i = 0; i < newmat.length; i++) {
			for (int j = 0; j < newmat.length; j++) {
				for (int k = 0; k < newmat.length; k++) {
					newmat[i][j] = (newmat[i][j] + mat1[i][k] * mat1[k][j])%1000;
				}
			}
		}

		if (B%2 != 0) {
			int[][] mat3 = new int[N][N];
			for (int i = 0; i < newmat.length; i++) {
				for (int j = 0; j < newmat.length; j++) {
					for (int k = 0; k < newmat.length; k++) {
						// 고해림 행렬 계산 왜 못하는데 ㅡㅡ 더하기 어디가쓴ㄴ데 미ㅏㅇㄴ~
						mat3[i][j] = (mat3[i][j] + newmat[i][k] * mat[k][j])%1000;
					}
				}
			}
			newmat = mat3;
		}
		

		return newmat;
	}
}