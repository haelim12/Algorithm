import java.util.*;
import java.io.*;

public class Main {
    
	static int N, strN, cnt;
	static StringBuilder sb = new StringBuilder();
	static String str, str2;
	
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        strN = 2*N + 1;
        sb.append("I");
        m(0);
        
        str = sb.toString();
        int len = Integer.parseInt(br.readLine());
        
        str2 = br.readLine();
        
        for (int i = 0; i < str2.length()-strN+1; i++) {
			m2(i);
		}
        
        System.out.println(cnt);
    }
    
    static void m(int cnt) {
    	if(cnt == N) return;
    	sb.append("OI");
    	m(cnt+1);
    }
    
    static void m2(int idx) {
    	String temp = str2.substring(idx, idx+strN);
    	if(temp.equals(str)) cnt++;
    }
    
    
    
}