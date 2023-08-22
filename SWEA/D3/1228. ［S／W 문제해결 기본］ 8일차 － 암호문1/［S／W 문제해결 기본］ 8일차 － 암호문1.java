import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			SinglyLinkedList list = new SinglyLinkedList();
			
			for (int i = 0; i < N; i++) {
				list.addLast(sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				String str = sc.next();
				int idx = sc.nextInt();
				int K = sc.nextInt();
				for (int k = 0; k < K; k++) {
					list.add(idx++, sc.nextInt());
				}
			}
			System.out.print("#" + tc + " ");
			list.printList();
		}
	}
}

class SinglyLinkedList {
	private Node head;
	private int size;

	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	// 조회
	public Node get(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}
	
	public void addLast(int data) {
		if (size == 0) {
			Node node = new Node(data);

			node.link = head;
			head = node;
			size++;
			return;
		}

		Node node = new Node(data);
		// 마지막 노드를 찾아가자.
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}

		curr.link = node;
		size++;
	}
	
	public void add(int idx, int data) {
		if (idx < 0 || idx > size) {
			return;
		}
		Node node = new Node(data);
		if (idx == 0) {
			node.link = head;
			head = node;
			size++;
			return;
		}
		
		if (idx == size) {
			Node curr = head;
			while (curr.link != null) {
				curr = curr.link;
			}
			curr.link = node;
			size++;
		}
		
		Node pre = get(idx - 1);
		
		node = new Node(data);
		node.link = pre.link;
		pre.link = node;
		size++;

	}
	
	public void printList() {
		Node curr = head;
		
		if (head == null) {
			return;
		}
		int count = 0;
		while (count < 10 && curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.link;
			count++;
		}
		System.out.println();
	}

}

class Node {
	public int data;
	public Node link;
	
	public Node() {
	}
	
	public Node(int data) {
		this.data = data;
		this.link = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}