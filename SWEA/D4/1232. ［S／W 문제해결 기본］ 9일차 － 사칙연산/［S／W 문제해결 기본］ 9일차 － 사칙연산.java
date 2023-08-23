import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
//	static List<String>
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
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
			System.out.printf("#%d %d\n", tc, (int) inorder(nodes[0]));
		}	
	}
	
	public static double inorder(Node node) {
		if (node.data.equals("+")) {
			return inorder(node.leftchild) + inorder(node.rightchild);
		} else if (node.data.equals("-")) {
			return inorder(node.leftchild) - inorder(node.rightchild);
		} else if (node.data.equals("*")) {
			return inorder(node.leftchild) * inorder(node.rightchild);
		} else if (node.data.equals("/")) {
			return inorder(node.leftchild) / inorder(node.rightchild);
		}
		else {
			return Double.parseDouble(node.data);
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