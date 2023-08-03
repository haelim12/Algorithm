import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stick = new Stack<>();

        String str = sc.nextLine();

        int cut = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // '(' 일 때 스택에 넣기
                stick.push("(");
            } else { // ')' 일 때
                if (str.charAt(i - 1) == '(') { // 앞에가 '('일 때
                    stick.pop(); // '(' 하나 pop 하고
                    cut += stick.size(); // 자르기 !
                } else { // 앞에가 ')' 일 때
                    stick.pop(); 
                    cut += 1; // 막대 하나 끝나서 조각 +1 해주기
                }
            }
        }
        System.out.println(cut);
    }
}
