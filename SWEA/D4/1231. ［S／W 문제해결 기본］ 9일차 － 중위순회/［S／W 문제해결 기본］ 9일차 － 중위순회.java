import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static char[] arr;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			
			N = sc.nextInt();
			Node[] nodes = new Node[N];

			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node();
			}
			sc.nextLine();
			for (int i = 0; i < nodes.length; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int trash = Integer.parseInt(st.nextToken());
				nodes[i].data = st.nextToken();
				if (st.hasMoreTokens()) {
					nodes[i].leftchild = nodes[Integer.parseInt(st.nextToken())-1];
				}
				if (st.hasMoreTokens()) {
					nodes[i].rightchild = nodes[Integer.parseInt(st.nextToken())-1];
				}
			}
			System.out.printf("#%d ",tc);
			inorder(nodes[0]);
			System.out.println();
		}
	}
	
	public static void inorder(Node node) {
		if (node.leftchild != null) {
			inorder(node.leftchild);
		}
		System.out.print(node.data);
		if (node.rightchild != null) {
			inorder(node.rightchild);
		}
	}
	
	public static class Node {
		String data;
		Node leftchild;
		Node rightchild;
		
		public Node() {
		}
	}
}